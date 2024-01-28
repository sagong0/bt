package Board.bt.controller;

import Board.bt.domain.Member;
import Board.bt.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;


    @GetMapping("/")
    public String mainPage(@CookieValue(name = "memberId", required = false) Long memberId, Model model){
        log.info("memberId = {} ", memberId);
        if(memberId == null){
            return "home";
        }
        Optional<Member> optionalMember = memberService.findUserByIdx(memberId);
        if(optionalMember.isEmpty()){
            return "home";
        }
        // 성공 로직 !
        model.addAttribute("member", optionalMember.get());
        return "loginHome";
    }
}
