package com.mountain.doo.dto.feed;


import lombok.*;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class FeedWriteRequestDTO {

    private String id;
    private String title;
    private String content;
}
