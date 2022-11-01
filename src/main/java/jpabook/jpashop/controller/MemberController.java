package jpabook.jpashop.controller;

import jpabook.jpashop.dto.createMemberDto;
import jpabook.jpashop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/members")
public class MemberController {
    private MemberService memberService;

    @GetMapping("/signup_form")
    String getSignupForm() {
        return "signUpForm";
    }

    @GetMapping()
    String list() {
        memberService.listMembers();
        return "listMembers";
    }

    @PostMapping
    String signup(createMemberDto memberDto) {
        memberService.join(memberDto);

        return "home";
    }
}
