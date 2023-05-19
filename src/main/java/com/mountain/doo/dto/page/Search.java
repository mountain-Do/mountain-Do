package com.mountain.doo.dto.page;

import com.mountain.doo.entity.SecondhandType;
import lombok.*;

@Setter
@Getter @ToString
public class Search extends Page{

    // 검색 타입, 검색 키워드
    private String type;
    private String keyword;

    public Search() {
        this.type = "";
        this.keyword = "";
    }
}
