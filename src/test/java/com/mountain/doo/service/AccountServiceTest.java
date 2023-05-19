package com.mountain.doo.service;

import com.mountain.doo.dto.AccountModifyDTO;
import com.mountain.doo.dto.LoginRequestDTO;
import com.mountain.doo.entity.Account;
import com.mountain.doo.entity.GENDER;
import com.mountain.doo.entity.LoginBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;
    PasswordEncoder encoder;




    @Test
    @DisplayName("DB에 회원정보 하나가 쌓여야 한다")
    void save(){
        Account save = new Account();
        save.setAccountId("11");
        save.setPassword("11");
        save.setName("11");
        save.setGender(GENDER.M);
        save.setEmail("11");
        save.setPhoneNo("11");
        save.setAddress("11");

        boolean isSaved = accountService.save(save);
        assertTrue(isSaved);

    }

/*    @Test
    @DisplayName("아이디 비밀번호 받아 맞는 정보 있으면 true 아니면 false")
    void login(){
        LoginRequestDTO dto = new LoginRequestDTO();
        dto.setAccount("11");
        dto.setPassword("11");
        dto.setAutoLogin(false);

        boolean a = accountService.login(dto);
        assertTrue(a);

    }*/

//        System.out.println("로그인성공");
//    }

    @Test
    @DisplayName("해당 아이디로 회원정보를 찾고 dto 정보를 수정하여 db에 저장해야 한다")
    void modify(){
        AccountModifyDTO build = new AccountModifyDTO();
        build.setPassword("123");
        build.setEmail("123");
        build.setPhoneNo("123");
        build.setAddress("123");
        build.setAccountId("admin");

        boolean b = accountService.modify(build.getAccountId(), build);
        System.out.println("b = " + b);
        assertTrue(b);


    }

}