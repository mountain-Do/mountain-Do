package com.mountain.doo.dto.issue;


import com.mountain.doo.entity.Issue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@ToString
@EqualsAndHashCode
public class IssueListResponseDTO {

    private final long boardNo;
    private final String title;
    private final String content;
    private final String date;
    private final long viewCount;
    private final String id;
    private final int likeCount;

    public IssueListResponseDTO(Issue issue) {
        this.boardNo = issue.getIssueBoardNo();
        this.title = issue.getIssueTitle();
        this.content = issue.getIssueContent();
        this.date = makePrettierDateString(issue.getIssueRegDate());
        this.viewCount = issue.getIssueViewCount();
        this.id = issue.getAccountId();
        this.likeCount = issue.getIssueLikeCount();
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

}
