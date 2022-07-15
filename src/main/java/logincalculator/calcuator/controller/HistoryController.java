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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;
    private final MemberService memberService;
    //C: 히스토리 생성
    @PostMapping("/history/create")
    public String addHistory(@RequestBody HashMap<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) return "/calculator/index";

        Object principal = auth.getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = ((UserDetails) principal).getUsername();
        Member member = memberService.findByUserName(username);

        String payload = (String) map.get("sendData");
        History history = new History();
        history.setContent(payload);
        history.setMember(member);
        member.getHistoryList().add(history);
        History newHistory = historyService.createHistory(history);
        return "/calculator/index";
    }


    //R: 히스토리 가져오기
    @GetMapping("/history/list")
    public String items(Model model) {
        System.out.println("THIS: /history/list");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) return "/calculator/index";
        Object principal = auth.getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = ((UserDetails) principal).getUsername();
        Member member = memberService.findByUserName(username);
        List<History> items = historyService.findByMember(member);
        for (History item : items) {
            String content = item.getContent();
            System.out.println("&& " + content);
        }
        model.addAttribute("items", items);
        return "/calculator/index";
    }
    //D: 히스토리 삭제
    @GetMapping("/history/delete/{historyId}")
    public String deleteHistory(@PathVariable long historyId, Model model) {
        System.out.println("THIS: /delete/{historyId}");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) return "/calculator/index";
        Object principal = auth.getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = ((UserDetails) principal).getUsername();
        Member member = memberService.findByUserName(username);
        historyService.deleteById(historyId);

        return "redirect:/history/list";
    }

}
