package Board.bt.controller;

import Board.bt.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/member/add")
    public String memberFormCreate(Model model){
        model.addAttribute("member", new Member());
        return "member/join";
    }

    @PostMapping("/member/add")
    public String memberForm(@ModelAttribute Member member){
        log.info("Member = {}", member);
        // Logic 추가 필요
        return "";
    }

    @PostMapping("/member/login")
    public String memberLogin(){

        return "redirect:/";
    }

}
