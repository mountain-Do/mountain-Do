package com.mountain.doo.repository;

import com.mountain.doo.dto.AccountModifyDTO;
import com.mountain.doo.dto.AutoLoginDTO;
import com.mountain.doo.dto.LoginRequestDTO;
import com.mountain.doo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {
    List<Account> allAccount();


    boolean save(Account account);

    //아이디로 회원정보 조회
    AccountModifyDTO searchInfoById(String accountId);

    boolean modifyInfo(AccountModifyDTO dto);

    //회원정보 삭제
    boolean deleteInfo(String accountId);


    Account myInfo(String accountId);

    //아이디 중복검사
    int isDuplicate(@Param("type") String type,@Param("keyword") String keyword);

    void saveAutoLogin(AutoLoginDTO build);

    Account findMemberByCookie(String sessionId);
}
