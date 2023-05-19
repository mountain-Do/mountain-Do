package com.mountain.doo.entity;


import com.mountain.doo.dto.feed.FeedRewriteRequestDTO;
import com.mountain.doo.dto.feed.FeedWriteRequestDTO;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feed {

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

    private long feedBoardNo;
    private String accountId;
    private String feedTitle;
    private String feedContent;
    private int feedLikeCount;
    private long feedViewCount;
    private LocalDateTime feedRegDate;
    private LocalDateTime feedModify;

    public Feed(FeedWriteRequestDTO dto) {
        this.accountId = dto.getId();
        this.feedTitle = dto.getTitle();
        this.feedContent = dto.getContent();
        this.feedRegDate = LocalDateTime.now();
    }


    public Feed(FeedRewriteRequestDTO dto) {
        this.accountId = dto.getId();
        this.feedTitle = dto.getTitle();
        this.feedContent  = dto.getContent();
        this.feedBoardNo  = dto.getBoardNo();
        this.feedModify = LocalDateTime.now();
    }
}
