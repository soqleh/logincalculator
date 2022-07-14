package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class) //junit에게 나 스프링과 관련된 걸 테스트 할거야 알려줌
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @org.junit.Test
    @Transactional
    //    @Rollback(false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUserId("aaaa");
        member.setUserRealName("memberA");
        member.setPw("1234");

        //when
        Long saveId = memberRepository.save(member);//ctrl+alt+v (변수명 뽑아서 생성하기)
        Member findMember = memberRepository.findByLoginId(saveId);
        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserId()).isEqualTo(member.getUserId());
        Assertions.assertThat(findMember.getUserRealName()).isEqualTo(member.getUserRealName());
        Assertions.assertThat(findMember.getPw()).isEqualTo(member.getPw());
        //        Assertions.assertThat(findMember).isEqualTo(member);//TURE: 같은 트랜잭션 안에서 저장/조회 시 영속성 Context 내이므로 id값이 같으면 1차 캐시로 부터 동일한 Entity리턴
    }

}