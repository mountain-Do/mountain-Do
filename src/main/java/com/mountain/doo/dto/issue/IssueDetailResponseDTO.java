package com.mountain.doo.dto.issue;



import com.mountain.doo.entity.Issue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
public class IssueDetailResponseDTO {

    private final long boardNo;
    private final String title;
    private final String content;
    private final String date;
    private final String writer;
    private final int likeCount;

    public IssueDetailResponseDTO(Issue issue) {
        this.boardNo = issue.getIssueBoardNo();
        this.title = issue.getIssueTitle();
        this.content = issue.getIssueContent();
        this.date = IssueListResponseDTO.makePrettierDateString(issue.getIssueRegDate());
        this.writer = issue.getAccountId();
        this.likeCount = issue.getIssueLikeCount();
    }
}
