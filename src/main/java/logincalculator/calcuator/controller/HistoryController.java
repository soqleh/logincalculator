package logincalculator.calcuator.controller;

import logincalculator.calcuator.domain.History;
import logincalculator.calcuator.domain.Member;
import logincalculator.calcuator.service.HistoryService;
import logincalculator.calcuator.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;
    private final MemberService memberService;
    //C: 히스토리 생성
    @PostMapping("/history/create")
    public String addHistory(@RequestBody HashMap<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) return "/home/index";

        Object principal = auth.getPrincipal();
        UserDetails userDetails = (UserDetails)principal;

        String username = ((UserDetails) principal).getUsername();
        String password = ((UserDetails) principal).getUsername();
//        System.out.println("username: " + username + ", password: " + password);
        String payload = (String) map.get("sendData");
        History history = new History();
        history.setFormula(payload);
        Member member = memberService.findByUserName(username);
        history.setMember(member);
        member.getHistoryList().add(history);
        History newHistory = historyService.createHistory(history);
        return "/home/index";
    }


    //R: 히스토리 가져오기

    //D: 히스토리 삭제

}
