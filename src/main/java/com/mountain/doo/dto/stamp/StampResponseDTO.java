package com.mountain.doo.dto.stamp;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class StampResponseDTO {
    private String accountId;
    private boolean attendCount;
    private int boardCount;
    private int bannerClickCount;
    private int totalStampCount;
}