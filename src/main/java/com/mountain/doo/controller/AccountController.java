package com.mountain.doo.controller;


import com.mountain.doo.dto.AccountModifyDTO;
import com.mountain.doo.dto.LoginRequestDTO;
import com.mountain.doo.entity.Account;
import com.mountain.doo.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
@Slf4j
public class AccountController {

    private final AccountService accountService;

    //회원가입페이지
    @GetMapping("/sign-up")
    public String signUp(){
        log.info("회원가입페이지");
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(Account account){
        log.info("가입처리요청");
        boolean save = accountService.save(account);
        if(save) {
            return "redirect:/login";  //로그인페이지
        }
        return "/sign-up"; // 회원가입페이지
    }

    @GetMapping("/modify")
    public String modify(){
        log.info("정보수정");
        return "";
    }


//정보수정
    @PostMapping("/modify")
    public String modify(String accountId,AccountModifyDTO dto){
        boolean modify = accountService.modify(accountId, dto);
        if(modify) {
            return "redirect:/main";  //수정하면 메인페이지
        }
        return  ""; //수정 안되면 수정페이지
    }

    @GetMapping("/mypage")
    public String mypage(Model model, String accountId){
        //회원정보 마이페이지
        Account account = accountService.myInfo(accountId);


        model.addAttribute("mypage",account);

        return "/mypage";
    }


    @GetMapping("/login")
    public String login(){

        return "/login";
    }


    @PostMapping("/login")
    public String login(LoginRequestDTO dto,
                        HttpServletResponse response,
                        HttpServletRequest request){
        boolean login = accountService.login(dto,request.getSession(),response);

        if(login){
            //service에 세션 보냄
            accountService.maintainAccountState(request.getSession(), dto.getAccount());
            return "redirect:/main"; //로그인되면 메인페이지
        }else {
            return "redirect:/login"; //로그인 안되면 로그인 페이지 다시
        }
    }

}
