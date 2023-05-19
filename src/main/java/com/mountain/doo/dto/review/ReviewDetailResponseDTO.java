package com.mountain.doo.dto.review;


import com.mountain.doo.entity.Feed;
import com.mountain.doo.entity.Review;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
public class ReviewDetailResponseDTO {

    private final long boardNo;
    private final String title;
    private final String content;
    private final String date;
    private final String writer;
    private final int likeCount;

    public ReviewDetailResponseDTO(Review review) {
        this.boardNo = review.getReviewBoardNo();
        this.title = review.getReviewTitle();
        this.content = review.getReviewContent();
        this.date = ReviewListResponseDTO.makePrettierDateString(review.getReviewRegDate());
        this.writer = review.getAccountId();
        this.likeCount = review.getReviewLikeCount();
    }
}
