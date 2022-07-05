package com.alevel.backend.domain.response;

public class ResponseMessage {
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    //public static final String SIGNUP_FAIL = "회원가입 실패";
    public static final String DUPLICATED = "중복된 값이 존재합니다.";
    public static final String NOT_DUPLICATED = "사용가능한 값입니다";
    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";
}
