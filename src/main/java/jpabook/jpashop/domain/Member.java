package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long Id;

    private String name;

    @Embedded
    private Address address;

    private String contact;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member() {
    }

    public Member(String name, String contact, Address address) {
        this.setName(name);
        this.setContact(contact);
        this.setAddress(address);
    }
}
