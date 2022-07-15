package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.History;
import logincalculator.calcuator.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {
    List<History> findByMember(Member member);
}
