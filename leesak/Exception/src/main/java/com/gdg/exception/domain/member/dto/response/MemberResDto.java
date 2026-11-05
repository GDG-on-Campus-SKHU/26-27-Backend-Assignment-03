package com.gdg.exception.domain.member.dto.response;

import com.gdg.exception.domain.member.entity.Member;
import com.gdg.exception.domain.member.entity.Part;
import lombok.Builder;

@Builder
public record MemberResDto(
        Long memberId,
        String name,
        String email,
        int age,
        String phoneNumber,
        Part part
) {
    public static MemberResDto from(Member member) {
        return MemberResDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .email(member.getEmail())
                .age(member.getAge())
                .phoneNumber(member.getPhoneNumber())
                .part(member.getPart())
                .build();
    }
}
