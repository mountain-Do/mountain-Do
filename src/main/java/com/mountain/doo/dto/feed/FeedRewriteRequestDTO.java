package com.mountain.doo.dto.feed;


import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class FeedRewriteRequestDTO {

    private String id;
    private String title;
    private String content;
    private int boardNo;
    private LocalDateTime modifyTime;

    public FeedRewriteRequestDTO(FeedRewriteRequestDTO feed) {
        this.id = feed.getId();
        this.title = feed.getTitle();
        this.content = feed.getContent();
        this.boardNo = feed.getBoardNo();
        this.modifyTime = LocalDateTime.now();
    }
}
