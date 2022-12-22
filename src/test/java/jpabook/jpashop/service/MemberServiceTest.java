package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.City;
import jpabook.jpashop.dto.createMemberDto;
import jpabook.jpashop.repository.MemberRepository;
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
public class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void signup() {
        createMemberDto memberDto = new createMemberDto(
                "seul",
                "010-0000-0000",
                new Address(City.Seoul, "first_street", "12345")
        );

        memberService.join(memberDto);

        Assertions.assertThat(memberDto.getName()).isEqualTo(memberRepository.findByName(memberDto.getName()).getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateDuplicateMember() {
        memberService.join(
                new createMemberDto(
                "seul",
                "010-0000-0000",
                new Address(City.Seoul, "first_street", "12345")
            )
        );

        memberService.join(
                new createMemberDto(
                        "seul",
                        "010-0000-0000",
                        new Address(City.Seoul, "first_street", "12345")
                )
        );
    }
}