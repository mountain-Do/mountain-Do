package com.mountain.doo.dto.review;


import com.mountain.doo.entity.Review;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@ToString
@EqualsAndHashCode
public class ReviewListResponseDTO {

    private final long boardNo;
    private final String title;
    private final String content;
    private final String date;
    private final long viewCount;
    private final String id;
    private final int likeCount;


    public ReviewListResponseDTO(Review review) {
        this.boardNo = review.getReviewBoardNo();
        this.title = review.getReviewTitle();
        this.content = review.getReviewContent();
        this.date = makePrettierDateString(review.getReviewRegDate());
        this.viewCount = review.getReviewViewCount();
        this.id = review.getAccountId();
        this.likeCount = review.getReviewLikeCount();
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }


}
