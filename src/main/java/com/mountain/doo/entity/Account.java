package com.mountain.doo.entity;

import com.mountain.doo.dto.AccountModifyDTO;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class Account {
    private String accountId;
    private String password;
    private String name;
    private GENDER gender;
    private String email;
    private String phoneNo;
    //나중에 오류 확인 
//    private String address;
    private String sessionId;
    private LocalDateTime limitTime;
    //실제로 클라에서 넘어오는 파일 데이터이므로 MultipartFile
//    private MultipartFile profileImage;
    //db에 저장된 이 파일의 경로이므로 String
    private String profileImg;
}
