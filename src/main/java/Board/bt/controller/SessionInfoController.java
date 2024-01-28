package Board.bt.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@Slf4j
@RestController
public class SessionInfoController {
    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session == null){
            return "NO SESSION !!!!";
        }
        session.getAttributeNames()
                .asIterator()
                .forEachRemaining(name -> log.info("session_name = {}, session_value = {}",name,session.getAttribute(name)));
        log.info("session ID = {}", session.getId());
        log.info("session.getMaxInactiveInterval = {}",session.getMaxInactiveInterval());
        log.info("session createdTime = {}", session.getCreationTime());
        log.info("session.getLastAccessedTime = {}", session.getLastAccessedTime());
        log.info("session.isNew = {}", session.isNew());

        return "세션 정보 출력";
    }
}
