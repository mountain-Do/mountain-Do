package com.mountain.doo.util;

import javax.servlet.http.HttpSession;

//회원 인증 인가 관련 상수와 메서드 가진 객체
public class LoginUtil {

    //로그인 세션 키
    public static final String LOGIN_KEY = "login";

    //로그인 여부 확인
    public static boolean isLogin(HttpSession session){
        return session.getAttribute(LOGIN_KEY)!=null;
    }

    //로그인한 사람의 계정명을 반환하는 메서드
//    public static String getcurrentLoginMemberAccount(HttpSession session){
//
//    }

    //자동로그인 쿠키 이름
    public static final String AUTO_LOGIN_COOKIE="auto";

}
