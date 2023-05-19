package com.mountain.doo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Stamp {
//    private int stampNo;
    private String accountId;
    private int attendCount;  //출석카운트
    private int boardCount; //게시글 작성 카운트
    private int bannerClickCount;  //배너 클릭 카운트
//    private int currentStampCount;   //현재 스탬프 개수
    private int totalStampCount;  //총 스탬프 개수


}
