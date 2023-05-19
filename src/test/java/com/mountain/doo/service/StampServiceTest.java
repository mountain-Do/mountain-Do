package com.mountain.doo.service;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.repository.StampMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StampServiceTest {
    @Autowired
    StampService service;

    @Test
    @DisplayName("아이디를 입력하면 스탬프 총 개수가 나와야 한다")
    void stampCount(){
        StampAddConditionDTO stampAddConditionDTO=new StampAddConditionDTO();
        stampAddConditionDTO.setAccountId("이동우");
        stampAddConditionDTO.setAttendCount(1);
        stampAddConditionDTO.setBoardCount(3);
        stampAddConditionDTO.setBannerClickCount(6);

        StampResponseDTO stampResponseDTO = service.stampCount(stampAddConditionDTO);
        System.out.println("stampAddConditionDTO = " + stampAddConditionDTO);
    }
}