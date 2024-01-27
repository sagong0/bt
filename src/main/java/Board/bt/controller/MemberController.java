package Board.bt.controller;

import Board.bt.domain.Member;
import Board.bt.domain.form.LoginForm;
import Board.bt.repository.member.LoginService;
import Board.bt.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final LoginService loginService;

        /*
    Spring Validation 사용 한 코드. **** (Bean Validation 으로 대체할거라 주석)
    private final MemberValidator memberValidator;
         */
    /*@InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(memberValidator);
    }*/

    @GetMapping("/member/add")
    public String memberFormCreate(Model model){
        model.addAttribute("member", new Member());
        return "member/join";
    }

    @PostMapping("/member/add")
    public String memberForm(@Validated @ModelAttribute Member member, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "member/join";
        }
        // 성공로직
        this.memberService.join(member);
        // 나중에 로그인 화면으로 리다이렉트 수정
        return "redirect:/";
    }

    /**
     * Id 중복 체크
     */
    @GetMapping("/member/check-userId/{userId}")
    @ResponseBody
    public String checkUserId(@PathVariable("userId") String userId){
        return memberService.userIdCheck(userId);
    }


    @GetMapping("/member/login")
    public String memberLoginForm(@ModelAttribute("form") LoginForm form){
        return "member/loginForm";
    }

    @PostMapping("/member/login")
    public String memberLogin(@Validated @ModelAttribute("form") LoginForm form,
                              BindingResult bindingResult, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return "member/loginForm";
        }

        Member loginMember = loginService.login(form.getUserId(), form.getUserpw());

        if(loginMember == null){
            bindingResult
                    .reject("loginFail", "아이디 또는 패스워드를 확인해주세요.");
            return "member/loginForm";
        }

        // 성공 로직 TODO! (일단 홈으로 보내놈)
        setCookie(response, loginMember);
        return "redirect:/";
    }

    @PostMapping("/member/logout")
    public String logoutMember(HttpServletResponse response){
        log.info("hrerererererer----");
        expiredCookie(response, "memberId");
        return "redirect:/";
    }


    /**
     * 편의 메소드
     */
    private void setCookie(HttpServletResponse response, Member loginMember) {
        Cookie cookie = new Cookie("memberId", String.valueOf(loginMember.getMidx()));
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    private void expiredCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}



