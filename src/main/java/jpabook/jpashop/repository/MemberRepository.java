package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member find(Long memberId) {
        return em.find(Member.class, memberId);
    }

    public List<Member> findByName(String name) {
        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m").getResultList();
    }
}
