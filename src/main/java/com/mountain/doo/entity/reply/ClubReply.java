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
public class ClubReply {
    private long clubReplyNo;
    private long clubBoardNo;
    private String clubReplyContent;
    private String clubReplyWriter;
    private LocalDateTime clubReplyDate;

}
