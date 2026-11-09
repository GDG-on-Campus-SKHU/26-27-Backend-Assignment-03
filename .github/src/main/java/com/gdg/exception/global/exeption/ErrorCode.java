package com.gdg.exception.global.exeption;

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
    URL_NOT_FOUND("COMMON_004", HttpStatus.NOT_FOUND, "URL이 올바르지 않습니다."),
    NOT_ALLOWED_HTTP_METHOD("COMMON_005", HttpStatus.METHOD_NOT_ALLOWED, "회원 수정 API는 현재 PUT만 지원합니다."),
    METHOD_TYPE_MISMATCH("COMMON_006", HttpStatus.BAD_REQUEST, "경로 변수가 올바르지 않습니다."),
    INVALID_MEDIA_TYPE("COMMON_007", HttpStatus.UNSUPPORTED_MEDIA_TYPE, "지원하지 않는 미디어 타입입니다."),

    // Member
    MEMBER_NOT_FOUND("MEMBER_001", HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    DUPLICATE_EMAIL("MEMBER_002", HttpStatus.CONFLICT, "이미 사용 중인 이메일입니다."),
    PASSWORD_MISMATCH("MEMBER_003", HttpStatus.BAD_REQUEST, "현재 비밀번호가 일치하지 않습니다."),
    SAME_PASSWORD("MEMBER_004", HttpStatus.BAD_REQUEST, "현재 비밀번호와 다른 비밀번호를 입력해주세요."),

    // Post
    POST_NOT_FOUND("POST_001", HttpStatus.NOT_FOUND, "존재하지 않는 게시글입니다.");

    private final String code;
    private final HttpStatus status;
    private final String message;
}
