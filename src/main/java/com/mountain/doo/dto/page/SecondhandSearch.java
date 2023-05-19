package com.mountain.doo.dto.page;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class SecondhandSearch extends Page {

    private String secondhandType;

    public SecondhandSearch() {
        this.secondhandType="";
        //"삽니다" 혹은 "팝니다" 둘 중 하나를 검색
    }
}
