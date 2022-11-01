package jpabook.jpashop.dto;

import jpabook.jpashop.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class createMemberDto {
    private String name;
    private String contact;
    private Address address;

    public createMemberDto(String name, String contact, Address address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }
}
