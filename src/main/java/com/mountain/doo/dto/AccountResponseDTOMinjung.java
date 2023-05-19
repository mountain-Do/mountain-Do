package com.mountain.doo.dto;

import lombok.*;

@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDTOMinjung {
    private String accountId;
    private String name;
}
