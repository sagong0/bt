package Board.bt.controller;

import Board.bt.domain.Member;
import Board.bt.domain.form.LoginForm;
import Board.bt.domain.form.MemberEditForm;
import Board.bt.exception.NoSuchIdxException;
import Board.bt.repository.member.LoginService;
import Board.bt.service.member.MemberService;
import Board.bt.utils.session.SessionConst;
import Board.bt.utils.session.SessionManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final LoginService loginService;
//    private final SessionManager sessionManager;

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
    public String memberLogin(
            @Validated @ModelAttribute("form") LoginForm form,
                              BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "member/loginForm";
        }

        Member loginMember = loginService.login(form.getUserId(), form.getUserpw());

        if(loginMember == null){
            bindingResult
                    .reject("loginFail", "아이디 또는 패스워드를 확인해주세요.");
            return "member/loginForm";
        }

        /** 쿠키만 사용해본 코드 **/
        // setCookie(response, loginMember);

        /****  직접 만든 세션 적용 코드 *****/
        //sessionManager.createSession(loginMember,response);

        /**** Servlet 제공 HttpSession 사용 코드 *****/
        // 세션 있으면 기존 세션, 없으면 새로운 세션 반환  : default(true)  // false null 반환
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        // 성공 로직 TODO! (일단 홈으로 보내놈)
        return "redirect:/";
    }

    @PostMapping("/member/logout")
    public String logoutMember(HttpServletRequest request){
//        expiredCookie(response, "memberId");  // 쿠키만 사용했을때
//        sessionManager.expireSession(request);    // 직접 만든 세션 코드
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping("/member/edit")
    public String editMemberFormCreate(@RequestParam Long midx,HttpServletRequest request ,Model model){
        return check_session(midx, request, model);
    }



    @PostMapping("/member/edit")
    public String editMemberForm(
            @Validated @ModelAttribute("member") MemberEditForm editForm,BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            return "member/edit";
        }

        // 성공 로직
        log.info("editForm = {}", editForm);
        memberService.updateMember(editForm);
        return "redirect:/";
    }



    /** 편의 메소드 **/
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

    // 페이지 강제접근 차단
    private String check_session(Long midx, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Member sessionMember =(Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        Optional<Member> optionalMember = memberService.findUserByIdx(midx);

        if(!sessionMember.getMidx().equals(midx)){
            // TODO 이 부분 예외 처리 해야할 것.
            throw new RuntimeException("잘못된 접근방법입니다.");
        }

        if(optionalMember.isEmpty()){
            // TODO 이 부분 예외 처리 해야할 것.
            throw new RuntimeException("잘못된 접근방법입니다.22");
        }
        // 성공 로직
        model.addAttribute("member", optionalMember.get());
        return "member/edit";
    }
}



