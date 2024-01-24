package Board.bt.controller;

import Board.bt.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepositoryImpl memberRepository;
    @GetMapping("/")
    public String mainPage(){

        memberRepository.findAll();
        return "index";
    }
}
