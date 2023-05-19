package com.mountain.doo.repository;

import com.mountain.doo.dto.ClubWriteRequestDTO;
import com.mountain.doo.dto.page.ClubSearch;
import com.mountain.doo.dto.page.Page;
import com.mountain.doo.dto.page.PageMaker;
import com.mountain.doo.entity.Club;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClubMapperTest {
    @Autowired
    ClubMapper mapper;

    @Test
    public void findAll(){
        ClubSearch page= ClubSearch.builder()
                .clubRecruitType("정기모임")
                .build();

        //when
        List<Club> replyList = mapper.findAll(page);
        for (int i = 0; i < replyList.size(); i++) {
        System.out.println("전체 조회 : " +replyList.get(i).getClubBoardNo()+ " "+ replyList.get(i).getAccountId()+ " "+replyList.get(i).getClubTitle());

        }
//        assertEquals(5,replyList.size());
//        assertEquals("이민정",replyList.get(0).getAccountId());
    }


    @Test
    void pageTest(){
        Page page = new Page();
        page.setPageNo(27);
        page.setAmount(10);

        PageMaker maker = new PageMaker(page, 284);
        System.out.println("maker = " + maker);

    }

    @Test
    //게시물 상세 조회
    public void findOneTest(){
        //given
        int clubBoardNo=4;
        //when
        System.out.println("findOne(clubBoardNo) = "+ mapper.findOne(clubBoardNo));
    }

    @Test
    //게시물 등록
    public void saveTest(){

    //given
        ClubWriteRequestDTO dto = ClubWriteRequestDTO.builder()
                .accountId("먕먕먕")
                .clubTitle("매주 토요일 등산 같이해요")
                .clubContent("매주 토요일 정기적으로 같이 등산 하실 분 모집합니다. 어디 산이든 좋아요")
                .clubArea("원하는 산 입구")
                .clubRecruitDeadline(LocalDateTime.of(2023, 06, 30, 8, 00))
                .clubRecruitType("정기모임")
                .clubRecruitCount(3)
                .build();
        Club c = new Club(dto);

        //when
        boolean flag=mapper.save(c);

        //then
        assertTrue(flag); //세이브가 성공했을 것이라고 단언
    }

    @Test
    public void deleteByNo(){
        //given
        int clubBoardNo=5;
        //when
        boolean flag=mapper.deleteByNo(clubBoardNo);
        //then
        assertTrue(flag);
    }

    @Test
    public void countTest(){
        ClubSearch search = new ClubSearch();
        int listCount = mapper.count(search);
        System.out.println("전체 개수 : "+listCount);
    }

}