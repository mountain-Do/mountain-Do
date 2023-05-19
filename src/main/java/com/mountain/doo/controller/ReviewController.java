package com.mountain.doo.controller;


import com.mountain.doo.dto.page.PageMaker;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.dto.review.ReviewListResponseDTO;
import com.mountain.doo.dto.review.ReviewRewriteRequestDTO;
import com.mountain.doo.dto.review.ReviewWriteRequestDTO;
import com.mountain.doo.entity.Review;
import com.mountain.doo.repository.ReviewMapper;
import com.mountain.doo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    // ==Review==
    // 전체 게시글 조회
    @GetMapping("/list")
    public String list(Search page, Model model){
        log.info("review list GET");
//        log.info(review.getReviewTitle());
        List<ReviewListResponseDTO> responseDTO = reviewService.getList(page);

        PageMaker maker = new PageMaker(page, reviewService.getCount(page));

        // 페이징 알고리즘 작동
        model.addAttribute("reviewList", responseDTO);
        model.addAttribute("reviewMaker", maker);
        model.addAttribute("r", page);


        return "";
    };
    // 게시글 상세 조회
    @GetMapping("/detail")
    public String detail(int boardNo, @ModelAttribute("s") Search search, Model model){
        log.info("review detail GET");
        model.addAttribute("review", reviewService.getDetail(boardNo));
        return "";
    }
    // 게시물 등록 화면 요청
    @GetMapping("/write")
    public String write(){
        System.out.println("/review/write : GET");
        return "";
    }
    // 게시물 등록 완료 처리
    @PostMapping("/write")
    public String write(ReviewWriteRequestDTO dto){
        System.out.println("/review/write : POST");
        reviewService.register(dto);
        return "";
    }

    // 수정 요청
    @GetMapping("/modify")
    public String modify(ReviewRewriteRequestDTO dto, @ModelAttribute("s") Search search, Model model){
        Review review = reviewMapper.findOne(dto.getBoardNo());
        model.addAttribute("bno", review.getReviewBoardNo());
        model.addAttribute("title", review.getReviewTitle());
        model.addAttribute("content", review.getReviewContent());
        model.addAttribute("modifyTime", review.getReviewModify());
        return "";
    }
    // 수정 완료 처리
    @PostMapping("/modify")
    public String modify(ReviewRewriteRequestDTO dto){
        reviewService.modify(dto);
        return "";
    }

    // 삭제
    @GetMapping("/delete")
    public String delete(int boardNo){
        reviewService.delete(boardNo);
        return  "";
    }



}
