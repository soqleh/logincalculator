package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.CalHistory;
import logincalculator.calcuator.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalHistoryRepositoryTest {
    @Autowired
    CalHistoryRepository historyRepository;

    @Test
    @Transactional
//    @Rollback(false)
    public void testHistory() throws Exception {
        //given
        CalHistory history = new CalHistory();
        //given
        Member member = new Member();
        member.setUserId("bbbb");
        member.setUserRealName("memberB");
        member.setPw("1234");
//        member.setId(100L);
        history.setFormula("1+2=3");
        history.setMember(member);
        //when
        CalHistory returnedHistory = historyRepository.save(history);
        //then
        Assertions.assertThat(returnedHistory).isEqualTo(history);
    }
}