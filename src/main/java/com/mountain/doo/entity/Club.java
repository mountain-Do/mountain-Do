package com.mountain.doo.entity;

import com.mountain.doo.dto.ClubWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Club {
    private int clubBoardNo; //글번호
    private String accountId; //작성사 id
    private String clubTitle; //제목
    private String clubContent; //내용
    private String clubArea; //모임 장소
    private LocalDateTime clubRegDate; // 작성일자시간
    private LocalDateTime clubModifyDate; // 수정일자
    private LocalDateTime clubRecruitDeadline; //마감 일자
    private String clubRecruitType; //모임 종류(정기모임인지 소모임인지)
    private int clubRecruitCount; //모집 인원

    public Club(ClubWriteRequestDTO dto){
        this.accountId=dto.getAccountId();
        this.clubTitle = dto.getClubTitle();
        this.clubContent = dto.getClubContent();
        this.clubArea=dto.getClubArea();
        this.clubRegDate = LocalDateTime.now();
        this.clubModifyDate = LocalDateTime.now();
        this.clubRecruitDeadline=dto.getClubRecruitDeadline();
        this.clubRecruitType=dto.getClubRecruitType();
        this.clubRecruitCount=dto.getClubRecruitCount();
    }

}
