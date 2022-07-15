package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        member.setUserName("aaaa");
        member.setPassword("1234");

        //when
        Member returendMember = memberRepository.save(member);//ctrl+alt+v (변수명 뽑아서 생성하기)
        Optional<Member> findMember = memberRepository.findByUserName(returendMember.getUserName());
        if(findMember.isPresent()) {
            //then
            Assertions.assertThat(findMember.get().getId()).isEqualTo(member.getId());
            Assertions.assertThat(findMember.get().getUserName()).isEqualTo(member.getUserName());
            Assertions.assertThat(findMember.get().getPassword()).isEqualTo(member.getPassword());
        }
        //        Assertions.assertThat(findMember).isEqualTo(member);//TURE: 같은 트랜잭션 안에서 저장/조회 시 영속성 Context 내이므로 id값이 같으면 1차 캐시로 부터 동일한 Entity리턴

    }

}