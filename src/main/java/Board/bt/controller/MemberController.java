package Board.bt.controller;

import Board.bt.domain.Member;
import Board.bt.service.member.MemberService;
import Board.bt.utils.MemberValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberValidator memberValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(memberValidator);
    }

    @GetMapping("/member/add")
    public String memberFormCreate(Model model){
        model.addAttribute("member", new Member());
        return "member/join";
    }

    @PostMapping("/member/add")
    public String memberForm(@Validated @ModelAttribute Member member, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.info("errors = {} ", bindingResult);
            return "member/join";
        }

        // 성공로직
        this.memberService.join(member);

        // 나중에 로그인 화면으로 리다이렉트 수정
        return "redirect:/";
    }

    @PostMapping("/member/login")
    public String memberLogin(){

        return "redirect:/";
    }

}
