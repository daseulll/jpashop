package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.dto.createMemberDto;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public void saveMember(createMemberDto memberDto) {
        Member member = new Member(memberDto.getName(), memberDto.getContact(), memberDto.getAddress());
        memberRepository.save(member);
    }
}
