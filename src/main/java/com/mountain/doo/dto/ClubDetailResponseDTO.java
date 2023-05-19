package com.mountain.doo.dto;

import com.mountain.doo.entity.Club;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString @EqualsAndHashCode
@RequiredArgsConstructor
public class ClubDetailResponseDTO {
    private final int clubBoardNo;
    private final String clubTitle;
    private final String clubContent;
    private final LocalDateTime clubRecruitDeadline;

    public ClubDetailResponseDTO(Club club) {
        this.clubBoardNo = club.getClubBoardNo();
        this.clubTitle = club.getClubTitle();
        this.clubContent = club.getClubContent();
        this.clubRecruitDeadline = club.getClubRegDate();
    }
}
