package com.gdg.exception.domain.member.dto.request;

import com.gdg.exception.domain.member.entity.Part;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MemberUpdateReqDto(
        @NotBlank(message = "이름을 입력해주세요.")
        @Size(max = 20, message = "이름은 20자 이하로 입력해주세요.")
        String name,

        @NotNull(message = "나이를 필수로 입력해야 합니다.")
        @Positive(message = "연나이를 입력해주세요.")
        Integer age,

        @NotBlank(message = "전화번호를 입력해주세요.")
        @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호는 010-0000-0000 형식으로 입력해주세요.")
        String phoneNumber,

        @NotNull(message = "파트를 선택해주세요.")
        Part part) {
}