package com.mountain.doo.dto.review;


import lombok.*;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ReviewWriteRequestDTO {

    private String id;
    private String title;
    private String content;
}
