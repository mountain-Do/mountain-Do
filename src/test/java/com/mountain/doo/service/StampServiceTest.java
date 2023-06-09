package com.mountain.doo.service;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.entity.Stamp;
import com.mountain.doo.repository.StampMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StampServiceTest {
    @Autowired
    StampService service;


//    @Test
//    @DisplayName("배너, 게시물, 출석 db에 + 시키기")
//    void stampAddCondition() {
//        StampAddConditionDTO dto = new StampAddConditionDTO();
//        dto.setBannerClickCount(true);
//        dto.setAttendCount(false);
//        dto.setClickEvent(false);
//        dto.setAccountId("myblog0419");
//
//        System.out.println("dto = " + dto);
//        Stamp stamp = service.stampCount(dto);
//        System.out.println("stamp = " + stamp);
//
//
//    }
//
//    @Test
//    @DisplayName("사용자의 데이터를 가지고 도장개수 return")
//    void stampCount(){
//        StampAddConditionDTO dto=new StampAddConditionDTO();
//        dto.setBannerClickCount(false);
//        dto.setClickEvent(true);
//        dto.setAttendCount(false);
//        dto.setAccountId("myblog0419");
//        Stamp stamp = service.stampCount(dto);
//        System.out.println("stamp = " + stamp);
//    }

    @Test
    @DisplayName("배너 보내고 받는거 확인")
    void test(){
        Stamp stamp = service.stampCount("myblog0419");

        StampAddConditionDTO dto =new StampAddConditionDTO();
        dto.setClickEvent(false);
        dto.setAccountId("myblog0419");
        dto.setAttendCount(false);
        dto.setBannerClickCount(true);

//        service.update(dto);
        Stamp stamp2 = service.stampCount(dto.getAccountId());
        System.out.println("stamp2 = " + stamp2);

    }


}