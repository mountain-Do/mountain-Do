package com.mountain.doo.controller;


import com.mountain.doo.dto.issue.IssueListResponseDTO;
import com.mountain.doo.dto.issue.IssueRewriteRequestDTO;
import com.mountain.doo.dto.issue.IssueWriteRequestDTO;
import com.mountain.doo.dto.page.PageMaker;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Issue;
import com.mountain.doo.repository.IssueMapper;
import com.mountain.doo.service.IssueService;
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
@RequestMapping("/issue")
@Slf4j
public class IssueController {

    private final IssueService issueService;
    private final IssueMapper issueMapper;

    // ==Issue==
    // 전체 게시글 조회
    @GetMapping("/list")
    public String list(Search page, Model model){
        log.info("issue list GET");
//        log.info(issue.getIssueTitle());
        List<IssueListResponseDTO> responseDTO = issueService.getList(page);

        PageMaker maker = new PageMaker(page, issueService.getCount(page));

        // 페이징 알고리즘 작동
        model.addAttribute("issueList", responseDTO);
        model.addAttribute("issueMaker", maker);
        model.addAttribute("i", page);

        return "";
    };
    // 게시글 상세 조회
    @GetMapping("/detail")
    public String detail(int boardNo, @ModelAttribute("s") Search search, Model model){
        log.info("issue detail GET");
        model.addAttribute("issue", issueService.getDetail(boardNo));
        return "";
    }
    // 게시물 등록 화면 요청
    @GetMapping("/write")
    public String write(){
        System.out.println("/issue/write : GET");
        return "";
    }
    // 게시물 등록 완료 처리
    @PostMapping("/write")
    public String write(IssueWriteRequestDTO dto){
        System.out.println("/feed/write : POST");
       issueService.register(dto);
        return "";
    }

    // 수정 요청
    @GetMapping("/modify")
    public String modify(IssueRewriteRequestDTO dto, @ModelAttribute("s") Search search, Model model){
        Issue issue = issueMapper.findOne(dto.getBoardNo());
        model.addAttribute("bno",issue.getIssueBoardNo());
        model.addAttribute("title", issue.getIssueTitle());
        model.addAttribute("content", issue.getIssueContent());
        model.addAttribute("modifyTime", issue.getIssueModify());
        return "";
    }
    // 수정 완료 처리
    @PostMapping("/modify")
    public String modify(IssueRewriteRequestDTO dto){
        issueService.modify(dto);
        return "";
    }

    // 삭제
    @GetMapping("/delete")
    public String delete(int boardNo){
        issueService.delete(boardNo);
        return  "";
    }



}
