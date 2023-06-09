package com.mountain.doo.repository;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.entity.Stamp;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StampMapperTest {

    @Autowired
    StampMapper mapper;

    @Test
    @DisplayName("배너클릭 , 게시판 작성시 +1씩 확인")
    void checkBannerCount() {

//고객 입력값
        StampAddConditionDTO dto = new StampAddConditionDTO();
        dto.setBannerClickCount(true);
        dto.setAttendCount(true);
        dto.setAccountId("myblog0419");

        //해당 아이디 정보 확인
        Stamp stamp = mapper.stampCount(dto.getAccountId());
        System.out.println("stamp = " + stamp);

        //보드 클릭시
        mapper.boardPlus(dto.getAccountId());
        System.out.println("stamp = " + stamp);

        //배너 클릭시
        mapper.bannerPlus(dto.getAccountId());
        System.out.println("stamp = " + stamp);
        System.out.println("dto = " + dto);

        //추가 클릭시 테스트
        mapper.boardPlus(dto.getAccountId());
        System.out.println("stamp = " + stamp);


    }

    @Test
    @DisplayName("배너가 3의 배수면 토탈 스탬프 개수 +1")
    void bannerPlus() {
        StampAddConditionDTO dto = new StampAddConditionDTO();
        dto.setBannerClickCount(true);
        dto.setAttendCount(true);
        dto.setAccountId("myblog0419");

        mapper.stampAdd(dto.getAccountId());

        Stamp stamp = mapper.stampCount(dto.getAccountId());
        System.out.println("stamp = " + stamp);
    }

    @Test
    @DisplayName("아이디로 내가쓴 게시물 찾기")
    void myboard() {
        Stamp stamp = mapper.stampCount("myblog0419");
        System.out.println("stamp = " + stamp);
        mapper.myBoard("myblog0419");
        Stamp stamp2 = mapper.stampCount("myblog0419");
        System.out.println("stamp2 = " + stamp2);
    }

    @Test

    @DisplayName("회원 추가")
    void addAccountTest(){
        String accountId="bbbb";
        mapper.addAccount(accountId);
    }

    @Test
    void findAccountCountTest(){
        String accountId="bbbb";
        boolean b = mapper.findAccountCount(accountId);

        System.out.println("bbbb : "+b);

        assertFalse(b);
    }

    @DisplayName("해당아이디가 쓴 오늘 날짜 게시물 수 확인")
    void todayMyBoard(){
        int i = mapper.todayMyBoard("myblog0419");

        System.out.println(i);


    }
    @Test
    @DisplayName("해당 아이디 카운트 리셋")
    void updateCount(){
        mapper.updateCount("myblog0419");
    }

}