package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    public void save() {
        Member member = new Member();
        member.setName("seul");

        memberRepository.save(member);

        Member findMember = memberRepository.find(member.getId());
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
}