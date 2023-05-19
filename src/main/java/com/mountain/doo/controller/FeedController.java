package com.mountain.doo.controller;


import com.mountain.doo.dto.feed.FeedListResponseDTO;
import com.mountain.doo.dto.feed.FeedRewriteRequestDTO;
import com.mountain.doo.dto.feed.FeedWriteRequestDTO;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.dto.page.PageMaker;
import com.mountain.doo.entity.Feed;
import com.mountain.doo.repository.FeedMapper;
import com.mountain.doo.service.FeedService;
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
@RequestMapping("/feed")
@Slf4j
public class FeedController {

    private final FeedService feedService;
    private final FeedMapper feedMapper;

    // ==Feed==
    // 전체 게시글 조회
    @GetMapping("/list")
    public String list(Search page, Model model){
        log.info("feed list GET");
//        log.info(feed.getFeedTitle());
        List<FeedListResponseDTO> responseDTO = feedService.getList(page);

        PageMaker maker = new PageMaker(page, feedService.getCount(page));

        // 페이징 알고리즘 작동
        model.addAttribute("feedList", responseDTO);
        model.addAttribute("feedMaker", maker);
        model.addAttribute("f", page);

        return "";
    };
    // 게시글 상세 조회
    @GetMapping("/detail")
    public String detail(int boardNo, @ModelAttribute("s") Search search, Model model){
        log.info("feed detail GET");
        model.addAttribute("feed", feedService.getDetail(boardNo));
        return "";
    }
    // 게시물 등록 화면 요청
    @GetMapping("/write")
    public String write(){
        System.out.println("/feed/write : GET");
        return "";
    }
    // 게시물 등록 완료 처리
    @PostMapping("/write")
    public String write(FeedWriteRequestDTO dto){
        System.out.println("/feed/write : POST");
        feedService.register(dto);
        return "";
    }

    // 수정 요청
    @GetMapping("/modify")
    public String modify(FeedRewriteRequestDTO dto, @ModelAttribute("s") Search search, Model model){
        Feed feed = feedMapper.findOne(dto.getBoardNo());
        model.addAttribute("bno",feed.getFeedBoardNo());
        model.addAttribute("title", feed.getFeedTitle());
        model.addAttribute("content", feed.getFeedContent());
        model.addAttribute("modifyTime", feed.getFeedModify());
        return "";
    }
    // 수정 완료 처리
    @PostMapping("/modify")
    public String modify(FeedRewriteRequestDTO dto){
        feedService.modify(dto);
        return "";
    }

    // 삭제
    @GetMapping("/delete")
    public String delete(int boardNo){
        feedService.delete(boardNo);
        return  "";
    }



}
