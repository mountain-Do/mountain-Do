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
public class SecondhandReply {

    private long secondhandReplyNo;
    private long secondhandBoardNo;
    private int secondhandReplyContent;
    private String secondhandReplyWriter;
    private LocalDateTime secondhandReplyDate;
}
