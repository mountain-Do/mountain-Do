package com.mountain.doo.dto.reply.feedreply;


import com.mountain.doo.dto.page.PageMaker;
import com.mountain.doo.entity.reply.FeedReply;
import lombok.*;

import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedReplyListResponseDTO {

    //데이터를 주기 위해 필요한 정보
    // 댓글 목록, 댓글 페이지 정보, 댓글 수

    private int replyCount;
    private PageMaker replyPage;
    private List<FeedReplyDetailResponseDTO> feedReplies;
}
