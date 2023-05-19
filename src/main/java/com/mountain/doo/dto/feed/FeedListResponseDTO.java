package com.mountain.doo.dto.feed;


import com.mountain.doo.entity.Feed;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@ToString
@EqualsAndHashCode
public class FeedListResponseDTO {

    private final long boardNo;
    private final String title;
    private final String content;
    private final String date;
    private final long viewCount;
    private final String id;
    private final int likeCount;


    public FeedListResponseDTO(Feed feed) {
        this.boardNo = feed.getFeedBoardNo();
        this.title = feed.getFeedTitle();
        this.content = feed.getFeedContent();
        this.date = makePrettierDateString(feed.getFeedRegDate());
        this.viewCount = feed.getFeedViewCount();
        this.id = feed.getAccountId();
        this.likeCount = feed.getFeedLikeCount();
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }


}
