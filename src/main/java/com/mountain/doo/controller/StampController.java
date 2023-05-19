package com.mountain.doo.controller;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.service.StampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stamp")
@Slf4j
public class StampController {

    private final StampService stampService;

    // 내 스탬프 보기
    @GetMapping("/myStamp")
    public String myStampPage(){
        return "/stampMyPage";
    }

    @PostMapping("/myStamp")
    public String myStampPage(StampAddConditionDTO dto, Model model){

        //id가 가지고 있는 총 스탬프 수
        StampResponseDTO stampCount = stampService.stampCount(dto);

        model.addAttribute("sc",stampCount);

        return "/stampMyPage";
    }




}
