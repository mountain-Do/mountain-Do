package com.mountain.doo.repository;


import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReviewMapper {


    // CRUD 기능을 명시

    // 전체 게시글 조회
    List<Review> findAll(Search page);

    // 게시글 상세 조회
    Review findOne(long reviewBoardNo);

    // 게시물 등록
    // 등록이 되었는가 안 됐는가
    boolean save(Review review);  // 게시물 정보 필요

    // 게시물 수정
    // 수정이 됐는가 안 됐는가
    boolean modifyReview(Review review);

    // 삭제
    boolean deleteReview(long reviewBoardNo); // 게시물 번호로 찾아서 삭제

    // 게시물 세기
    int reviewCount(Search search);

    // 조회수 상승
    void upViewCount(int reviewBoardNo);
}
