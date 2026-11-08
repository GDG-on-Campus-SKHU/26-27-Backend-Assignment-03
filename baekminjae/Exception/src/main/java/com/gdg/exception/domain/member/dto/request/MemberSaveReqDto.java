package com.gdg.exception.domain.member.dto.request;

import com.gdg.exception.domain.member.entity.Part;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MemberSaveReqDto(
        @NotBlank(message = "이름을 입력해주세요.")
        @Size(max = 20, message = "이름은 20자 이하로 입력해주세요.")
        String name,

        @NotBlank(message = "이메일을 입력해주세요.")
        @Email(message = "올바른 이메일 형식이 아닙니다.")
        String email,

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
        String password,

        @NotNull(message = "나이를 필수로 입력해야 합니다.")
        @Positive(message = "연나이를 입력해주세요.")
        Integer age,

        @NotBlank(message = "전화번호를 입력해주세요.")
        @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호는 010-0000-0000 형식으로 입력해주세요.")
        String phoneNumber,

        @NotNull(message = "파트를 선택해주세요.")
        Part part
) {
}
