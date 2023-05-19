package com.mountain.doo.repository;


import com.mountain.doo.dto.page.ClubSearch;
import com.mountain.doo.dto.page.Search;
import com.mountain.doo.entity.Club;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClubMapper {

    //게시물 목록 조회
//    List<Club> findAll();
    List<Club> findAll(ClubSearch page);

    //게시물 상세 조회
    Club findOne(int clubBoardNo);

    //게시물 등록
    boolean save(Club club);

    //게시물 삭제
    boolean deleteByNo(int clubBoardNo);



    //전체 글 개수 count
    int count(ClubSearch search);
//    int count();

}
