package com.mountain.doo.dto.review;


import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ReviewRewriteRequestDTO {

    private String id;
    private String title;
    private String content;
    private int boardNo;
    private LocalDateTime modifyTime;

    public ReviewRewriteRequestDTO(ReviewRewriteRequestDTO feed) {
        this.id = feed.getId();
        this.title = feed.getTitle();
        this.content = feed.getContent();
        this.boardNo = feed.getBoardNo();
        this.modifyTime = LocalDateTime.now();
    }
}
