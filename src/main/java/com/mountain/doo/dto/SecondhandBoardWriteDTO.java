package com.mountain.doo.dto;

import com.mountain.doo.entity.SecondhandType;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

public class SecondhandBoardWriteDTO {
    private String accountId;
    private String secondhandTitle;
    private String secondhandContent;
    private String secondhandArea;
    private SecondhandType secondhandDealType;

}
