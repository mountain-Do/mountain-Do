package com.mountain.doo.repository;

import com.mountain.doo.dto.page.Search;
import com.mountain.doo.dto.SecondhandBoardWriteDTO;
import com.mountain.doo.entity.SecondhandBoard;
import com.mountain.doo.entity.SecondhandType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SecondhandBoardMapperTest {

    @Autowired
    SecondhandBoardMapper mapper;

    @Test
    @DisplayName("거래타입별 필터링 후 게시물이 전체 출력되어야 한다")
    void findAllTest(){
        Search search =new Search();
        SecondhandType type = SecondhandType.BUY;


        List<SecondhandBoard> list = mapper.findAll(new Search());
//        search.setPageNo(1);
//        search.setAmount(10);
//        search.getPageStart();
        for (SecondhandBoard board : list) {
            if (board.getSecondhandDealType()==type){
                System.out.println("board = " + board);
            }
        }
    }
    @Test
    @DisplayName("boardNo가 들어오면 하나의 게시판이 출력되어야 한다")

    void findOne(){
        int boardNo = 10;
        SecondhandBoard one = mapper.findOne(boardNo);
        System.out.println("one = " + one);

    }

    @Test
    @DisplayName("아이디,제목,글,지역,글타입을 입력하면 하나의 게시글이 저장되어야 한다")
    void boardWrite(){

        SecondhandBoard sc=new SecondhandBoard();

        sc.setAccountId("asdqwe");
        sc.setSecondhandContent("나는 로보트입니다");
        sc.setSecondhandArea("달주이죠");
        sc.setSecondhandTitle("부산") ;
        sc.setSecondhandDealType(SecondhandType.SELL);

        mapper.handWriteData(sc);

        System.out.println("sc = " + sc);
    }
}