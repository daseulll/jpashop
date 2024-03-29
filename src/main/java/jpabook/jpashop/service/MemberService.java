package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.dto.createMemberDto;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void join(createMemberDto memberDto) {
        validateDuplicateMember(memberDto);
        Member member = new Member(memberDto.getName(), memberDto.getContact(), memberDto.getAddress());
        memberRepository.save(member);
    }

    private void validateDuplicateMember(createMemberDto memberDto) {
        Member member = memberRepository.findByName(memberDto.getName());

        if (!(member == null)) {
            throw new IllegalArgumentException("중복된 회원 이름입니다.");
        }
    }

    @Transactional(readOnly = true)
    public Member find(String name) {
        return memberRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<Member> listMembers() {
        return memberRepository.findAll();
    }
}
