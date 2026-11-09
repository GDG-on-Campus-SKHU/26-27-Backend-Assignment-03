package com.gdg.exception.domain.member.controller;

import com.gdg.exception.domain.member.dto.request.MemberPasswordUpdateReqDto;
import com.gdg.exception.domain.member.dto.request.MemberSaveReqDto;
import com.gdg.exception.domain.member.dto.request.MemberUpdateReqDto;
import com.gdg.exception.domain.member.dto.response.MemberResDto;
import com.gdg.exception.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResDto> saveMember(@Valid @RequestBody MemberSaveReqDto memberSaveReqDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(memberSaveReqDto));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResDto> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberResDto>> getMembers() {
        return ResponseEntity.ok(memberService.getAllMember());
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResDto> updateMember(@PathVariable Long memberId,
                                                     @Valid @RequestBody MemberUpdateReqDto memberUpdateReqDto) {
        return ResponseEntity.ok(memberService.updateMember(memberId, memberUpdateReqDto));
    }

    @PutMapping("/{memberId}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable Long memberId,
                                               @Valid @RequestBody MemberPasswordUpdateReqDto memberPasswordUpdateReqDto) {
        memberService.updatePassword(memberId, memberPasswordUpdateReqDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
