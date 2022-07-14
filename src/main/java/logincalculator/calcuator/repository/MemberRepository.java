package logincalculator.calcuator.repository;

import logincalculator.calcuator.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {//JPARepository
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findByLoginId(Long id) {
        return em.find(Member.class, id);
    }


}