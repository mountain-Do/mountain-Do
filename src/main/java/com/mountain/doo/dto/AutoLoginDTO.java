package com.mountain.doo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AutoLoginDTO {
    private String sessionId;
    private LocalDateTime limitTime;
    private String accountId;
}
