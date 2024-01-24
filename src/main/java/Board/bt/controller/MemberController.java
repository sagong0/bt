package Board.bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @GetMapping("/member/add")
    public String memberFormCreate(){
        return "member/join";
    }

    @PostMapping("/member/add")
    public String memberForm(){
        return "member/";
    }

    @PostMapping("/member/login")
    public String memberLogin(){

        return "redirect:/";
    }

}
