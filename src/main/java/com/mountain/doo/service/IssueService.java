package com.mountain.doo.service;


import com.mountain.doo.dto.issue.IssueDetailResponseDTO;
import com.mountain.doo.dto.issue.IssueListResponseDTO;
import com.mountain.doo.dto.issue.IssueRewriteRequestDTO;
import com.mountain.doo.dto.issue.IssueWriteRequestDTO;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Issue;
import com.mountain.doo.repository.IssueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class IssueService {

    //repository에 의존

    private final IssueMapper issueRepository;


    // 게시글 전체목록 처리
    public List<IssueListResponseDTO> getList(Search page){
        return issueRepository.findAll(page)
                .stream()
                .map(IssueListResponseDTO::new)
                .collect(toList());
    }

    // 게시글 상세조회 처리
    public IssueDetailResponseDTO getDetail(int issueNo){
        Issue issue = issueRepository.findOne(issueNo);

        //조회수 상승 처리
        issueRepository.upViewCount(issueNo);

        return new IssueDetailResponseDTO(issue);
    }

    // 글 등록 처리
    public boolean register(IssueWriteRequestDTO dto){
        Issue issue = new Issue(dto);
        return issueRepository.save(issue);
    };

    // 글 삭제 처리
    public boolean delete(int boardNo){
        return issueRepository.deleteIssue(boardNo);
    }

    // 글 수정 처리
    public boolean modify(IssueRewriteRequestDTO dto){
        return issueRepository.modifyIssue(new Issue(dto));
    }

    //페이징 처리 위한 count 처리
    public int getCount(Search search) {
        return issueRepository.issueCount(search);
    }

}
