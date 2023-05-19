<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="/assets/css/account-modify.css">
    <link rel="stylesheet" href="/assets/css/common.css">
    <%@ include file="../include/static-head.jsp" %>
    <title>Mountain-Do</title>
</head>

<body>
    <%@ include file="../include/header.jsp" %>
    <div class="container">
            <div class="modify-wrap">
                <div class="modify-header">
                    <div class="header">
                        <h1 class="head1">Mountain-Do</h1>
                        <h2 class="head2">회원 정보 수정</h2>
                    </div>
                </div>

                <div class="modify-body">
                    <form action="/account/modify" name="accountModify" id="accountModifyForm" method="post">
                        <ul>
                            <li>
                                <div>아이디</div>
                                    <span id="accound-id">"${a.accountId}"</span>
                            </li>
                            <li>
                                <div>이름</div>
                                <span id="user_name">"${a.name}"</span>
                            </li>
                            <li>
                                <div>비밀번호</div>
                                <div>
                                <input type="password" name="password" id="password" size="17" maxlength="20"
                                    class="form-control" maxlength="20" required="required" aria-required="true"
                                    placeholder="8자 이상 영문과 특수문자 조합">
                                    <span id="PWChk"></span>
                                </div>
                            </li>
                            <li>
                                <div>비밀번호 확인</div>
                                <div>
                                <input type="password" size="17" maxlength="20" id="re-password" name="re-password"
                                    class="form-control" maxlength="20" required="required" aria-required="true"
                                    placeholder="다시 한 번 입력하세요">
                                    <span id="PWReChk"></span>
                                </div>
                            </li>
                           
                            <li>
                                <div>이메일</div>
                                <div>
                                <input type="email" name="email" id="user-email" class="form-control"
                                    required="required" aria-required="true" placeholder="ex) abc1234@abcd.com">
                                    <span id="emailChk"></span>
                                 </div>
                            </li>
                            <li>
                                <div>휴대전화</div>
                                <div>
                                <input type="phone-no" name="phoneNo" id="phone-no" class="form-control"
                                    required="required" aria-required="true" maxlength="15"
                                    placeholder=" '-' 없이 입력해 주세요">
                                <span id="PhoneChk"></span>
                            </div>
                            </li>
                        </ul>

                        <div class="modify-btn">
                            <button class="btn">수정완료</button>
                        </div>
                    </form>
                    
                </div>
        </div>
    </div>
    </div>

    <script>
        // 입력값 검증 통과 여부 배열
        const checkResultList = [false, false, false, false, false];

       

            // 패스워드 검사 정규표현식
            const passwordPattern = /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]).{8,}/;

            // 패스워드 입력값 검증
            const $pwInput = document.getElementById('password');

            $pwInput.onkeyup = e => {

                const pwValue = $pwInput.value;
                // console.log(idValue);

                if (pwValue.trim() === '') {
                    $pwInput.style.borderColor = 'gray';
                    document.getElementById('PWChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 비밀번호를 입력해주세요.</b>';
                        checkResultList[1] = false;
                } else if (!passwordPattern.test(pwValue)) {
                    $pwInput.style.borderColor = 'gray';
                    document.getElementById('PWChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 특수문자 포함 8자 이상 작성해주세요.</b>';
                        checkResultList[1] = false;
                } else {

                    $pwInput.style.borderColor = '#1c5800';
                    document.getElementById('PWChk').innerHTML
                        = '<b style="color: #1c5800; font-size: 12px;"> - 사용가능한 비밀번호입니다.</b>';
                        checkResultList[1] = true;
                    
                }
            };


            // 패스워드 확인란 입력값 검증
            const $pwCheckInput = document.getElementById('re-password');

            $pwCheckInput.onkeyup = e => {

                const pwCheckValue = $pwCheckInput.value;

                if (pwCheckValue.trim() === '') {
                    $pwCheckInput.style.borderColor = 'gray';
                    document.getElementById('PWReChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 비밀번호 확인란은 필수값입니다.</b>';
                        checkResultList[2] = false;
                } else if ($pwCheckInput.value !== $pwInput.value) {
                    $pwCheckInput.style.borderColor = 'gray';
                    document.getElementById('PWReChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 위 내용과 동일하게 작성해주세요.</b>';
                        checkResultList[2] = false;
                } else {

                    $pwCheckInput.style.borderColor = '#1c5800';
                    document.getElementById('PWReChk').innerHTML
                        = '<b style="color: #1c5800; font-size: 12px;"> - 비밀번호가 확인되었습니다.</b>';
                        checkResultList[2] = true;
                    
                }
            };

            // 이메일 검사 정규표현식
            const emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

            // 아이디 입력값 검증
            const $emailInput = document.getElementById('user-email');

            $emailInput.onkeyup = e => {

                const emailValue = $emailInput.value;

                if (emailValue.trim() === '') {
                    $emailInput.style.borderColor = 'gray';
                    document.getElementById('emailChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 이메일 입력은 필수값입니다.</b>';
                        checkResultList[4] = false;
                } else if (!emailPattern.test(emailValue)) {
                    $emailInput.style.borderColor = 'gray';
                    document.getElementById('emailChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 이메일 형식에 맞게 작성해주세요.</b>';
                        checkResultList[4] = false;
                } else {$emailInput.style.borderColor = '#1c5800';
                                document.getElementById('emailChk').innerHTML
                                    = '<b style="color: #1c5800; font-size: 12px;"> - 사용가능한 이메일입니다.</b>';
                                    checkResultList[4] = true;
                            }
            };

            // 핸드폰번호 정규표현식
            const phonePattern = /^01[0-9]{8,9}$/;

             // 핸드폰번호 입력값 검증
            const $phoneInput = document.getElementById('phone-no');

            $phoneInput.onkeyup = e => {
                const phoneValue = $phoneInput.value;

                if (phoneValue.trim() === '') {
                    $phoneInput.style.borderColor = 'gray';
                    document.getElementById('PhoneChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 휴대전화 입력은 필수값입니다.</b>';
                } else if (!phonePattern.test(phoneValue)) {
                    $phoneInput.style.borderColor = 'gray';
                    document.getElementById('PhoneChk').innerHTML
                        = '<b style="color: gray; font-size: 12px;"> - 형식에 맞게 작성해주세요.</b>';
                } else {$phoneInput.style.borderColor = '#1c5800';
                                document.getElementById('PhoneChk').innerHTML
                                    = '<b style="color: #1c5800; font-size: 12px;"> - 형식에 맞게 입력되었습니다.</b>';
                            }
            };

    </script>

</body>

</html>