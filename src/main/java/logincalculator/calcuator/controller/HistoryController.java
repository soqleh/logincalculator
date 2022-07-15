package logincalculator.calcuator.controller;

import logincalculator.calcuator.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService calHistoryService;
    //C: 히스토리 생성
    @PostMapping("/create")
    public String addHistory(Model model, @RequestBody HashMap<String, Object> map) {
//        String payload = (String) map.get("payload");
//        System.out.println(payload);
//        History history = new History();
//        history.setContent(sendData);
//        history.setMember(member);
//        member.getHistories().add(history);
//        History newHistory = historyService.createHistory(history);
//
//        Member byId = memberService.findById(member.getId());
//        List<History> histories = byId.getHistories();
//        System.out.println("histories.size() = " + histories.size());
//
////        //연관 관계 설정 --> 변경감지라고 생각
////        history1.setMember(member);


        return "calculator_member";
    }
    //R: 히스토리 가져오기
    //D: 히스토리 삭제

}
