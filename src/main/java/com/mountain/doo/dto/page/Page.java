package com.mountain.doo.dto.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
//@ToString

public class Page {
    private int pageNo; // 클라이언트가 보낸 페이지 번호
    private int amount; // 클라이언트가 보낸 목록게시물 수


    public Page() {
        this.pageNo = 1;
        this.amount = 6;
    }

    //사용자가 다른 번호 입력하면 page는 1로
    public void setPageNo(int pageNo) {
//        if (pageNo != this.pageNo) {
//            this.pageNo = 1;
//        }
        this.pageNo = pageNo;
    }

    //사용자가 다른 번호 입력하면 amount 는 1로
    public void setAmount(int amount) {
        if (this.amount != amount) {
            this.amount = 6;
        }
    }

    //페이지에 게시글 몇개씩 띄울지
    public int getPageStart(){
        return (pageNo-1)*amount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", amount=" + amount +
                '}';
    }
}
