package com.mountain.doo.repository;

import com.mountain.doo.dto.stamp.StampAddConditionDTO;
import com.mountain.doo.dto.stamp.StampResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StampMapper {


    StampResponseDTO stampCount (String accountId);

    void stampUpdate(StampAddConditionDTO dto);

    void bannerPlus(StampAddConditionDTO dto);

    void boardPlus(StampAddConditionDTO dto);

    void booleanLogin(StampAddConditionDTO dto);




}
