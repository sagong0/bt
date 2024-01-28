package Board.bt.controller;

import Board.bt.domain.Member;
import Board.bt.service.member.MemberService;
import Board.bt.utils.session.SessionManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
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
    private final SessionManager sessionManager;

    /**
     * 쿠키만 사용해서 로그인 처리해본 코드
     */
    /*
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
     */

    /**
     * 직접 만든 SessionManager 적용 코드
     */
    @GetMapping("/")
    public String mainPage(HttpServletRequest request, Model model){
        // 세션 매니저에 저장된 객체 조회
        Member member_session = (Member) sessionManager.getSession(request);

        if(member_session == null){
            return "home";
        }

        model.addAttribute("member", member_session);
        return "loginHome";
    }
}
