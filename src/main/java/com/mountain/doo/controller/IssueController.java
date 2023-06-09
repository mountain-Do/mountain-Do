package com.mountain.doo.controller;


import com.mountain.doo.dto.AccountResponseDTO;
import com.mountain.doo.dto.feed.FeedLikeUserResponseDTO;
import com.mountain.doo.dto.issue.*;
import com.mountain.doo.dto.page.PageMaker;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.dto.review.ReviewDetailResponseDTO;
import com.mountain.doo.dto.review.ReviewLikeUserResponseDTO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        page.setAmount(15);
        log.info("issue list GET");
//        log.info(issue.getIssueTitle());
        List<IssueListResponseDTO> responseDTO = issueService.getList(page);

        PageMaker maker = new PageMaker(page, issueService.getCount(page));
        log.info("page : {}",page);
        System.out.println("maker = " + maker);
        // 페이징 알고리즘 작동
        model.addAttribute("iList", responseDTO);
        model.addAttribute("maker", maker);
        model.addAttribute("s", page);

        return "issue/issueList";
    };
    // 게시글 상세 조회
    @GetMapping("/detail")
    public String detail(int bno, @ModelAttribute("s") Search search, Model model, HttpServletRequest request){
        log.info("issue detail GET");

        Object login = request.getSession().getAttribute("login");
        IssueDetailResponseDTO detail = issueService.getDetail(bno);

        log.info("detail에 접근한 User의 정보 : {}", request.getSession().getAttribute("login"));
        log.info("detail 게시물 정보 : {}",detail);

        List<IssueLikeUserResponseDTO> byAccountDTO = issueService.findByAccount();
        boolean heartResult = isHeartResult(login, detail, byAccountDTO);

        log.info("Issue like 누른 회원들 계정 정보 출력 : {}",byAccountDTO);

        model.addAttribute("login",login);
        model.addAttribute("is", detail);
        model.addAttribute("i",heartResult);
        return "issue/issueDetail";
    }

    private boolean isHeartResult(Object login, IssueDetailResponseDTO detail, List<IssueLikeUserResponseDTO> byAccountDTO) {
        boolean heartResult = false;
        if (login != null) {
            String accountId = ((AccountResponseDTO) login).getAccountId();

            for (IssueLikeUserResponseDTO heartList : byAccountDTO) {
                if (heartList.getAccountId().equals(accountId)){
                    heartResult = true;
                    break;
                }else {
                    heartResult = false;
                }
            }
        }
        if (detail.getLikeCount() == 0){
            heartResult = false;
        }
        return heartResult;
    }

    // 게시물 등록 화면 요청
    @GetMapping("/write")
    public String write(HttpServletRequest request, Model model){
        System.out.println("/issue/write : GET");
        Object login = request.getSession().getAttribute("login");
        model.addAttribute("login",login);
        return "issue/issueWrite";
    }
    // 게시물 등록 완료 처리
    @PostMapping("/write")
    public String write(IssueWriteRequestDTO dto){
        System.out.println("/issue/write : POST");
       issueService.register(dto);
        return "redirect:/issue/list";
    }

    // 수정 요청
    @GetMapping("/modify")
    public String modify(int bno, Model model){
        Issue issue = issueMapper.findOne(bno);
        IssueListResponseDTO modifyIssue = new IssueListResponseDTO(issue);

        model.addAttribute("is",modifyIssue);

        return "issue/issueModify";
    }
    // 수정 완료 처리
    @PostMapping("/modify")
    public String modify(IssueRewriteRequestDTO dto){
        IssueRewriteRequestDTO requestDTO = new IssueRewriteRequestDTO(dto);
        System.out.println("requestDTO = " + requestDTO);
        boolean modify = issueService.modify(requestDTO);

        return "redirect:/issue/detail?bno="+requestDTO.getBoardNo();
    }

    // 삭제
    @GetMapping("/delete")
    public String delete(int bno){
        issueService.delete(bno);
        return  "redirect:/issue/list";
    }
//    @PostMapping("/")




}
