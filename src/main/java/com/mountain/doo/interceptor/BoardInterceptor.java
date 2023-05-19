package com.mountain.doo.interceptor;

//컨트롤러 요청 전 후 공통 검사 정의
//게시판 관련 인가 처리

import com.mountain.doo.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@Slf4j
public class BoardInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //로그인 했는지 확인
        if(!LoginUtil.isLogin(request.getSession())){
            log.info("this request({}) denied!!", request.getRequestURI());
            response.sendRedirect("/sing-in"); //로그인화면으로 돌려보냄
            return false;
        }

        log.info("회원정보 확인");
        return true;
        //로그인 x 시 로그인페이지로 redirect

    }
}
