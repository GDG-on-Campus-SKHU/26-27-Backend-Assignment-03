package com.gdg.exception.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INTERNAL_SERVER_ERROR("COMMON_001", HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다."),
    INVALID_INPUT_VALUE("COMMON_002", HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다."),
    INVALID_REQUEST_BODY("COMMON_003", HttpStatus.BAD_REQUEST, "요청 본문의 형식이 올바르지 않습니다."),

    // Member
    MEMBER_NOT_FOUND("MEMBER_001", HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    DUPLICATE_EMAIL("MEMBER_002", HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다."),
    PASSWORD_MISMATCH("MEMBER_003", HttpStatus.BAD_REQUEST, "현재 비밀번호가 일치하지 않습니다."),
    SAME_PASSWORD("MEMBER_004", HttpStatus.BAD_REQUEST, "현재 비밀번호와 다른 비밀번호를 입력해주세요."),

    // Post
    POST_NOT_FOUND("POST_001", HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다."),

    //URL
    URL_NOT_FOUND("URL_001", HttpStatus.NOT_FOUND, "존재하지 않는 URL입니다."),
    PATH_MISMATCH("URL_002", HttpStatus.BAD_REQUEST, "경로 변수에 잘못된 값을 넣었습니다."),

    //METHOD
    METHOD_NOT_SUPPORT("METHOD_001", HttpStatus.BAD_REQUEST, "지원하지 않는 HTTP메서드입니다."),
    TEXT_NOT_SUPPORT("METHOD_002", HttpStatus.BAD_REQUEST, "지원하지 않는 Content-Type입니다.");

    private final String code;
    private final HttpStatus status;
    private final String message;
}
