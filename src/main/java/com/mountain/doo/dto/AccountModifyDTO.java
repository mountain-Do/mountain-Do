package com.mountain.doo.dto;

import com.mountain.doo.entity.Account;
import com.mountain.doo.repository.AccountMapper;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class AccountModifyDTO {
    private String accountId;
    private String password;
    private String email;
    private String phoneNo;
    private String address;

    PasswordEncoder encoder;

    public AccountModifyDTO changeAccount(AccountModifyDTO dto){
        AccountModifyDTO build = AccountModifyDTO.builder()
                .password(dto.getPassword())
                .email(dto.getEmail())
                .phoneNo(dto.getPhoneNo())
                .address(dto.getAddress())
                .build();
        return build;
    }

}
