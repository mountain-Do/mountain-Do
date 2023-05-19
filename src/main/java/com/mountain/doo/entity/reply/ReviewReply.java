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
public class ReviewReply {

    private long reviewReplyNo;
    private long reviewBoardNo;
    private String reviewReplyContent;
    private String reviewReplyWriter;
    private LocalDateTime reviewReplyDate;

}
