package com.shop.entity;

import com.shop.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.shop.dto.MemberFormDto;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member") //데이터베이스 테이블이름 지정
@Getter@Setter
@ToString
public class Member {
    @Id
    @Column(name = "member_id") //속성 이름을 지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    //생성 방식을 지정
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String address;

    @Enumerated(EnumType.STRING)//열거형으로 지정
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto,
                                      PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(member.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }
}
