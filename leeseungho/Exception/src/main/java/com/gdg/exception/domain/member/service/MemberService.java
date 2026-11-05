package com.gdg.exception.domain.member.service;

import com.gdg.exception.domain.member.dto.request.MemberPasswordUpdateReqDto;
import com.gdg.exception.domain.member.dto.request.MemberSaveReqDto;
import com.gdg.exception.domain.member.dto.request.MemberUpdateReqDto;
import com.gdg.exception.domain.member.dto.response.MemberResDto;
import com.gdg.exception.domain.member.entity.Member;
import com.gdg.exception.domain.member.repository.MemberRepository;
import com.gdg.exception.global.exception.BadRequestException;
import com.gdg.exception.global.exception.ConflictException;
import com.gdg.exception.global.exception.ErrorCode;
import com.gdg.exception.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResDto saveMember(MemberSaveReqDto memberSaveReqDto) {
        if (memberRepository.existsByEmail(memberSaveReqDto.email())) {
            throw new ConflictException(ErrorCode.DUPLICATE_EMAIL);
        }

        Member member = Member.builder()
                .name(memberSaveReqDto.name())
                .email(memberSaveReqDto.email())
                .password(memberSaveReqDto.password())
                .age(memberSaveReqDto.age())
                .phoneNumber(memberSaveReqDto.phoneNumber())
                .part(memberSaveReqDto.part())
                .build();

        memberRepository.save(member);
        return MemberResDto.from(member);
    }

    public MemberResDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        return MemberResDto.from(member);
    }

    public List<MemberResDto> getAllMember() {
        return memberRepository.findAll().stream()
                .map(MemberResDto::from)
                .toList();
    }

    @Transactional
    public MemberResDto updateMember(Long memberId, MemberUpdateReqDto memberUpdateReqDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        member.update(memberUpdateReqDto);
        return MemberResDto.from(member);
    }

    @Transactional
    public void updatePassword(Long memberId, MemberPasswordUpdateReqDto memberPasswordUpdateReqDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        if (!member.getPassword().equals(memberPasswordUpdateReqDto.currentPassword())) {
            throw new BadRequestException(ErrorCode.PASSWORD_MISMATCH);
        }

        if (member.getPassword().equals(memberPasswordUpdateReqDto.newPassword())) {
            throw new BadRequestException(ErrorCode.SAME_PASSWORD);
        }

        member.updatePassword(memberPasswordUpdateReqDto);
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        memberRepository.delete(member);
    }
}
