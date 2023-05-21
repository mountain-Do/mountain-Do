package com.mountain.doo.dto.stamp;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class StampAddConditionDTO {
    private String accountId;
    private int attendCount;
    private int boardCount;
    private int bannerClickCount;
    private int currentStampCount;
    private int totalStampCount;
}
