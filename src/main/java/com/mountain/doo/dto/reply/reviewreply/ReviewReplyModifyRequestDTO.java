package com.mountain.doo.dto.reply.reviewreply;


import com.mountain.doo.entity.reply.FeedReply;
import lombok.*;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewReplyModifyRequestDTO {
    @NotNull
    private Long boardNo;
    @NotNull
    private Long replyNo;
    @NotNull
    private String content;

    public FeedReply toEntity() {
        return FeedReply.builder()
                .feedReplyNo(this.replyNo)
                .feedBoardNo(this.boardNo)
                .feedReplyContent(this.content).build();
    }
}
