package com.mountain.doo.repository;


import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Feed;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FeedMapperTest {

    @Autowired
    FeedMapper feedMapper;
    @Test
    @DisplayName("피드의 모든 게시물을 불러들여야 한다")
    void findAllTest(){
        Search page = new Search();
        page.setPageNo(1);
        page.setAmount(4);

        List<Feed> feed = feedMapper.findAll(page);
        System.out.println("feed = " + feed);

        assertNotNull(feed);
        assertEquals(4, feed.size());

    }
    @Test
    @DisplayName("2번 피드 게시글의 조회에 성공해야 한다")
    void findOneTest(){
         Long feedBoardNo = 2L;
        Feed feed = feedMapper.findOne(feedBoardNo);
        System.out.println("feed = " + feed);
        assertNotNull(feed);
        assertEquals(feedBoardNo, feed.getFeedBoardNo());

    }

    @Test
    @DisplayName("글 등록에 성공해야 한다")
    void feedRegisterTest() {
        Feed feed = Feed.builder()
                .accountId("user")
                .feedTitle("등산 조아요")
                .feedContent("오늘은 북한산")
                .build();

        boolean flag = feedMapper.save(feed);
        assertTrue(flag);
    }

    @Test
    @DisplayName("글 삭제에 성공해야 한다")
    void feedDeleteTest() {
        //given
        long feedBoardNo = 1L;

        //when
        boolean flag = feedMapper.deleteFeed(feedBoardNo);

        //then
        assertTrue(flag);

    }

    @Test
    @DisplayName("글 수정에 성공해야 한다")
    void feedModifyTest() {
        //given
        long feedBoardNo = 2L;
        String newFeedTitle = "등산 후기";
        String newFeedContent = "등산 재미있어";


        Feed f = Feed.builder()
                .feedBoardNo(feedBoardNo)
                .feedTitle(newFeedTitle)
                .feedContent(newFeedContent)
                .feedModify(LocalDateTime.now())
                .build();

        //when
        boolean flag = feedMapper.modifyFeed(f);

        //then
        assertTrue(flag);
        assertEquals(newFeedContent, feedMapper.findOne(feedBoardNo).getFeedContent());


    }

}