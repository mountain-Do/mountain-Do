package com.mountain.doo.entity.reply;


import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedReply {

    private long feedReplyNo;
    private long feedBoardNo;
    private String feedReplyContent;
    private String feedReplyWriter;
    private LocalDateTime feedReplyDate;
}
