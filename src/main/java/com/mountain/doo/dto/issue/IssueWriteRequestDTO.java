package com.mountain.doo.dto.issue;


import lombok.*;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class IssueWriteRequestDTO {
    private String id;
    private String title;
    private String content;
}
