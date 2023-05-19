package com.mountain.doo.dto.issue;


import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class IssueRewriteRequestDTO {
    private String id;
    private String title;
    private String content;
    private int boardNo;
    private LocalDateTime modifyTime;

    public IssueRewriteRequestDTO(IssueRewriteRequestDTO issue) {
        this.id = issue.getId();
        this.title = issue.getTitle();
        this.content = issue.getContent();
        this.boardNo = issue.getBoardNo();
        this.modifyTime = issue.getModifyTime();
    }
}
