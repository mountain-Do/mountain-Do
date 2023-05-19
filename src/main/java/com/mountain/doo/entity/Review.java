package com.mountain.doo.entity;


import com.mountain.doo.dto.review.ReviewRewriteRequestDTO;
import com.mountain.doo.dto.review.ReviewWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    //    CREATE TABLE feed(
//            feed_board_no INT(10) AUTO_INCREMENT PRIMARY KEY,
//    account_id VARCHAR(16),
//    feed_title VARCHAR(100),
//    feed_content VARCHAR(3000),
//    feed_like_count INT(5),
//    feed_view_count INT(10) DEFAULT 0,
//    feed_reg_date DATETIME DEFAULT current_timestamp,
//    feed_modify DATETIME,
//#     CONSTRAINT FOREIGN KEY (account_id) REFERENCES account(account_id) on DELETE CASCADE
//);

    private long reviewBoardNo;
    private String accountId;
    private String reviewTitle;
    private String reviewContent;
    private int reviewLikeCount;
    private long reviewViewCount;
    private LocalDateTime reviewRegDate;
    private LocalDateTime reviewModify;

    public Review(ReviewWriteRequestDTO dto) {
        this.accountId = dto.getId();
        this.reviewTitle = dto.getTitle();
        this.reviewContent = dto.getContent();
        this.reviewRegDate = LocalDateTime.now();
    }


    public Review(ReviewRewriteRequestDTO dto) {
        this.accountId = dto.getId();
        this.reviewTitle = dto.getTitle();
        this.reviewContent  = dto.getContent();
        this.reviewBoardNo  = dto.getBoardNo();
        this.reviewModify = LocalDateTime.now();
    }
}
