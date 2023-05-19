package com.mountain.doo.dto.feed;


import com.mountain.doo.entity.Feed;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
public class FeedDetailResponseDTO {

    private final long boardNo;
    private final String title;
    private final String content;
    private final String date;
    private final String writer;
    private final int likeCount;

    public FeedDetailResponseDTO(Feed feed) {
        this.boardNo = feed.getFeedBoardNo();
        this.title = feed.getFeedTitle();
        this.content = feed.getFeedContent();
        this.date = FeedListResponseDTO.makePrettierDateString(feed.getFeedRegDate());
        this.writer = feed.getAccountId();
        this.likeCount = feed.getFeedLikeCount();
    }
}
