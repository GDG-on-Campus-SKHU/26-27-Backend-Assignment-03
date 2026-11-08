package com.gdg.exception.domain.member.entity;

import com.gdg.exception.domain.member.dto.request.MemberPasswordUpdateReqDto;
import com.gdg.exception.domain.member.dto.request.MemberUpdateReqDto;
import com.gdg.exception.domain.post.entity.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private int age;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Part part;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Builder
    private Member(String name, String email, String password, int age, String phoneNumber, Part part) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.part = part;
    }

    public void update(MemberUpdateReqDto memberUpdateReqDto) {
        this.name = memberUpdateReqDto.name();
        this.age = memberUpdateReqDto.age();
        this.phoneNumber = memberUpdateReqDto.phoneNumber();
        this.part = memberUpdateReqDto.part();
    }

    public void updatePassword(MemberPasswordUpdateReqDto memberPasswordUpdateReqDto) {
        this.password = memberPasswordUpdateReqDto.newPassword();
    }
}
