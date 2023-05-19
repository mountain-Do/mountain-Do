package com.mountain.doo.service;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import com.mountain.doo.repository.StampMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StampService {
    private final StampMapper mapper;

    public StampResponseDTO stampCount(StampAddConditionDTO dto) {
        //조건별 데이터 전달
        stampAddCondition(dto);
        StampResponseDTO stampCount = mapper.stampCount(dto.getAccountId());

        return stampCount;

    }
    //로그인, 게시글작성, 배너 클릭시 각각 칼럼 count ++
    //고객 입력 값 conditionDTO로 받아 DB에서 체크하고 StampResponseDTO 로  return
    public void stampAddCondition(StampAddConditionDTO dto){
                mapper.bannerPlus(dto);
                mapper.boardPlus(dto);
                mapper.booleanLogin(dto);
                mapper.stampUpdate(dto);

    }


}
