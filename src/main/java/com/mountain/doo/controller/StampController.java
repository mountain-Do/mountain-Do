package com.mountain.doo.controller;

import com.mountain.doo.dto.AccountResponseDTO;
import com.mountain.doo.dto.LoginUserResponseDTO;
import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.entity.Stamp;
import com.mountain.doo.service.StampService;
import com.mountain.doo.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
@Slf4j
public class StampController {

    private final StampService stampService;

    // 내 스탬프 보기
    @GetMapping("/stamp")
    public String myStampPage( Model model, HttpSession session){

        AccountResponseDTO loginUserData = (AccountResponseDTO) session.getAttribute(LoginUtil.LOGIN_KEY);

        String accountId=loginUserData.getAccountId();

        log.info("Get Stamp 요청 accountId: "+accountId);

        Stamp stamp = stampService.stampCount(accountId);

        ;


        log.info("스탬프 : "+stamp.getAccountId());
        System.out.println("스탬프 : "+stamp);
        model.addAttribute("stamp",stamp);

//        stampService.loginStamp(StampAddConditionDTO,accountId);

/*
        dto.setAccountId(loginUserData.getAccountId());

        //id가 가지고 있는 총 스탬프 수
        Stamp stampCount = stampService.stampCount(dto);
        stampService.boardBanner(dto);


//        model.addAttribute("stamp",stampCount);


        return "/event/stamp";

    }


//    @GetMapping("/banner-count")
//    @ResponseBody
//    public ResponseEntity<?> bannerCount(StampAddConditionDTO dto, Model model) {
//        log.info("/stamp/banner-count?type={}&keyword={} ASYNC GET!");
//        stampService.boardBanner(dto);
//        return ResponseEntity.ok().body();
//
//    }
    @PostMapping("/banner-count")
    @ResponseBody
    public void handleBannerClick(@RequestBody StampAddConditionDTO stampAdd) {

        log.info("스탬프 비동기 : "+stampAdd);
        String userId = stampAdd.getAccountId();
//        boolean flag = (boolean) stampAdd.get();

        // 클릭 횟수 증가 또는 저장 로직 구현
        incrementClickCount(stampAdd.getAccountId(), stampAdd.isBannerClickCount());
    }

        private void incrementClickCount(String accountId, boolean bannerClickCount) {
            // 클릭 횟수를 저장하는 데이터베이스에 접근하여 클릭 횟수 증가 또는 저장 작업 수행
            // 예: 클릭 횟수 정보를 데이터베이스에서 조회하고, 증가시킨 후 다시 저장


        }

        log.info("스탬프 비동기 : "+stampAdd);
//        String userId = stampAdd.getAccountId();
//        boolean flag = (boolean) stampAdd.get();
        stampService.update(stampAdd);


        // 클릭 횟수 증가 또는 저장 로직 구현
//    incrementClickCount(stampAdd.getAccountId(), stampAdd.isBannerClickCount());


    }

}