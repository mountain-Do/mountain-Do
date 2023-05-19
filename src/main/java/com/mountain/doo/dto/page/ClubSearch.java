package com.mountain.doo.dto.page;


import lombok.*;

@Setter
@Getter
//@ToString
@AllArgsConstructor
@Builder
public class ClubSearch extends Page {

    private String clubRecruitType;
//    검색기능 할거면 사용
//    private String keyword;

    public ClubSearch() {
        this.clubRecruitType = "";
//        this.keyword="";
    }

    @Override
    public String toString() {
        return "ClubSearch{" +
                "clubRecruitType='" + clubRecruitType + '\'' +
                "} " + super.toString();
    }
}
