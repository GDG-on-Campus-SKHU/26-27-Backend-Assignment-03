package com.gdg.exception.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;import jakarta.validation.constraints.Size;
public record PostUpdateReqDto(
        @NotBlank(message = "제목을 입력해주세요.")
        @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.")
        String title,

        @NotBlank(message = "내용을 입력해주세요.")
        String contents
) {
}