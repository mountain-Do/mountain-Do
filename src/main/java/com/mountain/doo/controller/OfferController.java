package com.mountain.doo.controller;

import com.mountain.doo.dto.AccountResponseDTO;
import com.mountain.doo.dto.OfferImageResponseDTO;
import com.mountain.doo.dto.OfferResponseDTO;
import com.mountain.doo.dto.OfferWriteRequestDTO;
import com.mountain.doo.service.OfferService;
import com.mountain.doo.util.FileUtil;
import com.mountain.doo.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/offer")
@Slf4j
public class OfferController {

    @Value("${file.upload.root-path}")
    private String rootPath;
    private final OfferService offerService;

    @GetMapping("/offer-main")
    public String offer(Model model) {
          log.info("offer-main GET!!!!!!!!");
   
        log.info("산 추천");

        //게시글 없으면 바로 글쓰기 페이지로 이동
        findOffer("산 추천");

        Integer boardNo = offerService.findBoardNo("산 추천");
       log.info("boardNo = {}", boardNo);
        if(boardNo==null) return "offer/offer-writer-editor";
        OfferResponseDTO text = offerService.findText(boardNo);
        List<OfferImageResponseDTO> image = offerService.findImage(boardNo);
        log.info("산 추천 text : "+text);
        log.info("산 추천 image : "+image);

        model.addAttribute("text",text);
        model.addAttribute("image",image);
        return "offer/offer-main";
    }

    @GetMapping("offer-eat")
    public String offerEat(Model model) {
        log.info("맛집 추천");

        //게시글 없으면 바로 글쓰기 페이지로 이동
        findOffer("맛집 추천");
//        int isNull = offerService.findMountain("맛집 추천");
//        if(isNull==0) return "offer/offer-writer";

        Integer boardNo = offerService.findBoardNo("맛집 추천");
        if(boardNo==null) return "offer/offer-writer-editor";

        OfferResponseDTO text = offerService.findText(boardNo);
        List<OfferImageResponseDTO> image = offerService.findImage(boardNo);
        log.info("산 추천 text : "+text);

        model.addAttribute("text",text);
        model.addAttribute("image",image);
        return "offer/offer-restaurant";
    }

    public String findOffer(String s){
        Integer isNull = offerService.findMountain(s);
        if(isNull==null) return "offer/offer-writer-editor";
        else return "true";
    }


    //글쓰기 버튼 클릭
    @GetMapping("write")
    public String write(){
        log.info("추천정보 글쓰기");

        return "offer/offer-writer-editor";
    }

    @PostMapping("/offer-writer-editor")
    public String postWrite(OfferWriteRequestDTO dto, HttpSession session) {
        log.info("글쓰기 완료 요청");
        log.info("OfferWriteRequestDTO : "+dto);
//        log.info("imageDto" + imgDto);

        List<String> filePathList = new ArrayList<>();
        dto.getOfferImage().forEach(img -> {
            if (!img.isEmpty()) {
                log.info("img-name: {}", img.getOriginalFilename());
                //루트 디렉토리 생성
                File root = new File(rootPath);
                if (!root.exists()) root.mkdirs();

                String filePath = FileUtil.uploadFile(img, rootPath);
                log.info("file-patj: {}", filePath);
                filePathList.add(filePath);
            }
        });
        AccountResponseDTO attribute = (AccountResponseDTO) session.getAttribute(LoginUtil.LOGIN_KEY);
        offerService.save(dto,attribute.getAccountId(), filePathList);

        return "redirect:/offer/offer-main";
    }

}
