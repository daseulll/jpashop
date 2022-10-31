package jpabook.jpashop.dto;

import jpabook.jpashop.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class createMemberDto {
    private String name;
    private String contact;
    private Address Address;
}
