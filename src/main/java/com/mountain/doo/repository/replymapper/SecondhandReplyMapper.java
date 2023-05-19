package com.mountain.doo.repository.replymapper;


import com.mountain.doo.dto.page.Page;
import com.mountain.doo.entity.reply.SecondhandReply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Mapper
public interface SecondhandReplyMapper {
    // 기능 명시

    // 댓글 등록
    boolean register(SecondhandReply secondhandReply);

    // 댓글 수정
    boolean modify(SecondhandReply secondhandReply);

    // 댓글 삭제
    boolean remove(long secondhandBoardNo);

    // 댓글 목록 조회
    List<SecondhandReply> findAll(
            long secondhandBoardNo
            ,   @RequestParam("p") Page page
    ); //특정 게시물의 댓글 목록 조회, 페이징 처리

    // 댓글 개별 조회
    SecondhandReply findOne(long secondhandReplyNo);

    // 댓글 수 조회
    int count(long secondhandBoardNo); //특정 게시물의 댓글 수 조회

}
