package com.mountain.doo.repository;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
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
    @DisplayName("아이디를 입력하면 스탬프 총 개수가 나와야 한다")
    void stampCount() {
        StampAddConditionDTO stampAddConditionDTO=new StampAddConditionDTO();
        stampAddConditionDTO.setAccountId("이동우");
        stampAddConditionDTO.setAttendCount(1);
        stampAddConditionDTO.setBoardCount(3);
        stampAddConditionDTO.setBannerClickCount(6);

        // mapper.stampCount 메서드를 호출하여 스탬프 총 개수를 가져온다
        StampResponseDTO stampCount = mapper.stampCount(stampAddConditionDTO.getAccountId());
        System.out.println("stampCount = " + stampCount);
    }

//   @Test
//    @DisplayName("배너클릭이 3번이 되면 스탬프수 +1, id 값 들어와야 한다1")
//    void checkBannerCount(){
//        mapper.stampUpdate("이동우"){
//
//       }
//   }

}