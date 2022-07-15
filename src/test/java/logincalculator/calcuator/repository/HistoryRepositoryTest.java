package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.History;
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
public class HistoryRepositoryTest {
    @Autowired
    HistoryRepository historyRepository;

    @Test
    @Transactional
//    @Rollback(false)
    public void testHistory() throws Exception {
        //given
        History history = new History();
        //given
        Member member = new Member();
        member.setUserName("bbbb");
        member.setPassword("1234");
//        member.setId(100L);
        history.setContent("1+2=3");
        history.setMember(member);
        //when
        History returnedHistory = historyRepository.save(history);
        //then
        Assertions.assertThat(returnedHistory).isEqualTo(history);
    }
}