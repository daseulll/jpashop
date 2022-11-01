package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.dto.createMemberDto;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void saveMember(createMemberDto memberDto) {
        validateDuplicateMember(memberDto);
        Member member = new Member(memberDto.getName(), memberDto.getContact(), memberDto.getAddress());
        memberRepository.save(member);
    }

    private void validateDuplicateMember(createMemberDto memberDto) {
        List<Member> members = memberRepository.findByName(memberDto.getName());

        if (members.size() >= 1) {
            throw new IllegalArgumentException("중복된 회원 이름입니다.");
        }
    }
}
