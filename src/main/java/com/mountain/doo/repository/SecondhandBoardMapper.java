package com.mountain.doo.repository;

import com.mountain.doo.dto.page.Search;
import com.mountain.doo.dto.SecondhandBoardWriteDTO;
import com.mountain.doo.dto.page.SecondhandSearch;
import com.mountain.doo.entity.SecondhandBoard;
import com.mountain.doo.entity.SecondhandType;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface SecondhandBoardMapper {

    //전체 게시판 조회
    List<SecondhandBoard>findAll(SecondhandSearch page);


    //게시판 하나 조회
    SecondhandBoard findOne(int secondHandBoardNo);

    //게시물 작성
    boolean handWriteData(SecondhandBoard board);

    //조회수 +1 증가
    boolean plusViewCount(int secondHandBoardNo);

    //게시판 전체수 조회
    int count(SecondhandSearch search);

    // 게시물 수정
    // 수정이 됐는가 안 됐는가
    boolean modifySecondhand(SecondhandBoard secondhandBoard);

    //삭제
    boolean deleteSecondhand(int secondhandBoardNo);
}
