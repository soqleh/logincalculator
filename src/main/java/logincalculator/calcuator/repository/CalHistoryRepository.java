package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.CalHistory;
import logincalculator.calcuator.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalHistoryRepository extends JpaRepository<CalHistory,Long> {
    List<CalHistory> findByMember(Member member);
}
