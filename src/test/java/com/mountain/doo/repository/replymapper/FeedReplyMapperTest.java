package com.mountain.doo.repository.replymapper;


import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Feed;
import com.mountain.doo.entity.reply.FeedReply;
import com.mountain.doo.repository.FeedMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FeedReplyMapperTest {

    @Autowired
    FeedMapper feedMapper;
    @Autowired
    FeedReplyMapper feedReplyMapper;

    @Test
    @DisplayName("게시물 100개를 등록하고 " +
            "각 게시물에 랜덤으로 500개의 " +
            "댓글을 나눠서 등록해야 한다.")
    void bulkInsertTest() {

        for (int i = 1; i <= 100; i++) {
            Feed f = Feed.builder()
                    .accountId("admin")
                    .feedTitle("재밌는 게시물 " + i)
                    .feedContent("노잼 게시물 내용 " + i)
                    .build();
            feedMapper.save(f);
        }
        assertEquals(100, feedMapper.feedCount(new Search()));

        for (int i = 1; i <= 500; i++) {
            FeedReply fr = FeedReply.builder()
                    .feedBoardNo((long) (Math.random() * 100 + 1))
                    .feedReplyContent("말똥이~~~" + i)
                    .feedReplyWriter("잼민이 " + i)
                    .build();
            feedReplyMapper.register(fr);
        }

    }

}