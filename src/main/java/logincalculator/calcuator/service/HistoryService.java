package logincalculator.calcuator.service;

import logincalculator.calcuator.domain.History;
import logincalculator.calcuator.domain.Member;
import logincalculator.calcuator.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;

    public History createHistory(History history){
        return historyRepository.save(history);
    }

    public List<History> findByMember(Member member){
        return historyRepository.findByMember(member);
    }

    public History findById(long historyId){
        return historyRepository.findById(historyId).orElse(null);
    }

    public void deleteById(History history){
        historyRepository.delete(history);
    }
}
