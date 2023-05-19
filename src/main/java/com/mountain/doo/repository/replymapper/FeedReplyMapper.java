package com.mountain.doo.repository.replymapper;


import com.mountain.doo.dto.page.Page;
import com.mountain.doo.entity.reply.FeedReply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Mapper
public interface FeedReplyMapper {
    // 기능 명시

    // 댓글 등록
    boolean register(FeedReply feedReply);

    // 댓글 수정
    boolean modify(FeedReply feedReply);

    // 댓글 삭제
    boolean remove(long feedBoardNo);

    // 댓글 목록 조회
    List<FeedReply> findAll(
                long feedBoardNo
            ,   @RequestParam("p") Page page
    ); //특정 게시물의 댓글 목록 조회, 페이징 처리

    // 댓글 개별 조회
    FeedReply findOne(long feedReplyNo);

    // 댓글 수 조회
    int count(long feedBoardNo); //특정 게시물의 댓글 수 조회

}
