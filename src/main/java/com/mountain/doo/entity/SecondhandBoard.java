package com.mountain.doo.entity;

import com.mountain.doo.dto.SecondhandBoardListDTO;
import com.mountain.doo.dto.SecondhandBoardWriteDTO;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecondhandBoard {
    private int secondHandBoardNo;
    private String accountId;
    private String secondhandTitle;
    private String secondhandContent;
    private int secondhandView;
    private String secondhandArea;
    private LocalDateTime secondhandRegDate;
    private SecondhandType secondhandDealType;

    //전체게시판
public SecondhandBoard(SecondhandBoardListDTO dto){
    this.secondHandBoardNo=dto.getSecondHandBoardNo();
    this.accountId=dto.getAccountId();
    this.secondhandTitle=dto.getSecondhandTitle();
    this.secondhandView=dto.getSecondhandView();
    this.secondhandArea=dto.getSecondhandArea();
    this.secondhandRegDate=LocalDateTime.now();
    this.secondhandDealType=dto.getSecondhandDealType();
}

    //게시글 작성
public SecondhandBoard(SecondhandBoardWriteDTO dto){
    this.secondhandTitle=dto.getSecondhandTitle();
    this.secondhandContent=dto.getSecondhandContent();
    this.secondhandArea=dto.getSecondhandArea();
    this.secondhandRegDate=LocalDateTime.now();
    this.secondhandDealType=dto.getSecondhandDealType();
}

}


