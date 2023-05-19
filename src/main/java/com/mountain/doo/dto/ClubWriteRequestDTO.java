package com.mountain.doo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubWriteRequestDTO {
    private String accountId;
    private String clubTitle;
    private String clubContent;
    private String clubArea; //모임 장소
    private LocalDateTime clubRecruitDeadline; //마감 일자
    private String clubRecruitType; //모임 종류(정기모임인지 소모임인지)
    private int clubRecruitCount; //모집 인원


}
