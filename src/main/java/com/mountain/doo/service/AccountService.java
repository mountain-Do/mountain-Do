package com.mountain.doo.service;


import com.mountain.doo.dto.AccountModifyDTO;
import com.mountain.doo.dto.AccountResponseDTOMinjung;
import com.mountain.doo.dto.AutoLoginDTO;
import com.mountain.doo.dto.LoginRequestDTO;
import com.mountain.doo.entity.Account;
import com.mountain.doo.entity.LoginBoolean;
import com.mountain.doo.repository.AccountMapper;
import com.mountain.doo.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

import static com.mountain.doo.entity.LoginBoolean.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
    private final AccountMapper mapper;
    private final PasswordEncoder encoder;

    public List<Account> allAccount(){
        return mapper.allAccount();
    }

    //로그인 검증?
    public boolean login(LoginRequestDTO dto,
                         HttpSession session,
                         HttpServletResponse response){
        LoginBoolean loginBoolean = loginBoolean(dto);


        if (loginBoolean.equals(SUCCESS)) {
            log.info("로그인 성공");
            //자동로그인 여부 확인
            if(dto.isAutoLogin()){
                //자동 로그인 처리 쿠키 생성
                Cookie autoLoginCookie = new Cookie(LoginUtil.AUTO_LOGIN_COOKIE,session.getId());
                //쿠키 셋팅
                int limitTime = 60*60*24*90;
                autoLoginCookie.setMaxAge(limitTime);
                autoLoginCookie.setPath("/");
                //쿠키를 클라이언트에 응답 전송
                response.addCookie(autoLoginCookie);
                //DB에도 쿠키에 저장된 값과 수명을 저장
                mapper.saveAutoLogin(
                        AutoLoginDTO.builder()
                                .sessionId(session.getId())
                                .accountId(dto.getAccount())
                                .limitTime(LocalDateTime.now().plusDays(90))
                                .build()
                );
            }
            return true;
        }else if(loginBoolean.equals(FALSE_PW)){
            log.info("비밀번호 틀림");
            return false;
        }else{
            log.info("회원가입요망");
            return false;
        }
        
        
    }

    //계정확인여부
    public LoginBoolean loginBoolean(LoginRequestDTO dto){
        Account account = mapper.myInfo(dto.getAccount()); //아이디로 계정찾기

        //비밀번호 확인
        boolean matches = encoder.matches(dto.getPassword(), account.getPassword());

        if(account==null) {
            return NOT_FOUND;
        }else if(!matches){
            return FALSE_PW;
        }else {
            return SUCCESS;
        }
    }

    public boolean save(Account account) {
                account.setPassword(encoder.encode(account.getPassword()));

        return mapper.save(account);
    }


    public boolean modify(String accountId,AccountModifyDTO dto){
        AccountModifyDTO account = mapper.searchInfoById(accountId);
        AccountModifyDTO accountModifyDTO = account.changeAccount(dto);
        accountModifyDTO.setPassword(encoder.encode(dto.getPassword()));
        accountModifyDTO.setAccountId(accountId);
       return mapper.modifyInfo(accountModifyDTO);


    }
    public boolean deleteInfo(String accountId){
        return mapper.deleteInfo(accountId);
    }

    public Account myInfo(String accountId) {
        return mapper.myInfo(accountId);
    }

    // 로그인 성공시 세션에 로그인한 회원의 정보 저장
    public void maintainAccountState(HttpSession session, String accountId){
        Account account = myInfo(accountId);

        //현재 로그인한 사람의 화면에 보여줄 일부정보 -> dto
        AccountResponseDTOMinjung dto=AccountResponseDTOMinjung.builder()
                .name(account.getAccountId())
                .name(account.getName())
                .build();
        //이 정보들을 세션에 저장
        session.setAttribute(LoginUtil.LOGIN_KEY,dto);
        // 세션의 수명을 설정
        session.setMaxInactiveInterval(60 * 60);
    }
}
