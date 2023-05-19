package com.mountain.doo.interceptor;

import com.mountain.doo.entity.Account;
import com.mountain.doo.repository.AccountMapper;
import com.mountain.doo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;

import static com.mountain.doo.util.LoginUtil.AUTO_LOGIN_COOKIE;

@Configuration
@RequiredArgsConstructor
public class AutoLoginInterceptro implements HandlerInterceptor {

    private final AccountMapper accountMapper;
    private final AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie c = WebUtils.getCookie(request, AUTO_LOGIN_COOKIE);

        if(c!=null){ //자동 로그인 쿠키 가지고 있으면

            //쿠키에 저장된 세션아이디를 읽는다.
            String sessionId = c.getValue();

            //DB에서 세션아이디로 회원정보를 조회한다.
            Account foundMember = accountMapper.findMemberByCookie(sessionId);

            //회원이 조회가 되었고 자동로그인 만료일 이전이라면
            if(foundMember !=null && LocalDateTime.now().isBefore(foundMember.getLimitTime())){
                //5. 로그인 처리
                accountService.maintainAccountState(request.getSession(),foundMember.getAccountId());
            }
        }
        return true;
    }
}