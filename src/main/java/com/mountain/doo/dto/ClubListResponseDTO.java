package com.mountain.doo.dto;


import com.mountain.doo.entity.Club;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter @RequiredArgsConstructor
@Getter
public class ClubListResponseDTO {
    private final int clubBoardNo; //글번호
    private final String clubTitle; //제목
    private final String clubContent; //내용
    private final String clubRegdate; // 날짜패턴 yyyy-MM-dd HH:mm
    private final String clubArea; //모임 장소
    private final LocalDateTime clubRecruitDeadline; //마감 일자
    private  final String clubRecruitType; //모임 종류(정기모임인지 소모임인지)
    private int clubRecruitCount; //모집 인원

    public ClubListResponseDTO(Club club){
        this.clubBoardNo = club.getClubBoardNo();
        this.clubTitle = club.getClubTitle();
        this.clubContent = club.getClubContent();
        this.clubRegdate = makePrettierDateString(club.getClubRegDate());
        this.clubArea = club.getClubArea();
        this.clubRecruitDeadline=club.getClubRecruitDeadline();
        this.clubRecruitType=club.getClubRecruitType();
        this.clubRecruitCount=club.getClubRecruitCount();
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

}
