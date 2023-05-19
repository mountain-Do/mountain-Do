package com.mountain.doo.entity;


import com.mountain.doo.dto.issue.IssueRewriteRequestDTO;
import com.mountain.doo.dto.issue.IssueWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Issue {

//    create table issue(
//            issue_board_no int(10) auto_increment primary key,
//    account_id varchar(16) not null,
//    issue_title varchar(100) not null,
//    issue_content varchar(3000) not null,
//    issue_like_count int(5) default 0,
//    issue_view_count int(10) default 0,
//    issue_reg_date datetime default current_timestamp,
//    issue_modify datetime DEFAULT current_timestamp
//);

    private long issueBoardNo;
    private String accountId;
    private String issueTitle;
    private String issueContent;
    private int issueLikeCount;
    private long issueViewCount;
    private LocalDateTime issueRegDate;
    private LocalDateTime issueModify;

    public Issue(IssueWriteRequestDTO dto) {
        this.accountId = dto.getId();
        this.issueTitle = dto.getTitle();
        this.issueContent = dto.getContent();
        this.issueRegDate = LocalDateTime.now();
    }


    public Issue(IssueRewriteRequestDTO dto) {
        this.accountId = dto.getId();
        this.issueTitle = dto.getTitle();
        this.issueContent  = dto.getContent();
        this.issueBoardNo  = dto.getBoardNo();
        this.issueModify = LocalDateTime.now();
    }
}
