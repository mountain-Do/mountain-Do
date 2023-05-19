<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- header -->
<header class="header-container">
    <div class="header-wrapper">
        <ul class="category-wrapper">
            <li><a href="/account/offer-main" class="category-offer">추천 정보</a></li>
            <li><a href="" class="category-community">커뮤니티</a></li>
            <li><a href="/club/list" class="category-club">모임</a></li>
            <li><a href="" class="category-secondhand">중고거래</a></li>
            <li><a href="/event/stamp" class="category-event">스탬프</a></li>
        </ul>
        <img src="/assets/jpg/logo(white).png" alt="" class="logo">

        <ul class="login-wrapper">
            <li><a href="/account/sign-up" class="signUp-btn">Sign up</a></li>
            <li><a href="/account/sign-in" class="signIn-btn">Sign in</a></li>
        </ul>

        <!-- Login 되면 보여질 버튼  -->
        <!-- 
    <ul class="afterLogin-wrapper">
        <li class="logout-btn"><a href="">Log out</a></li>
        <li class="myPage-btn"><a href="/account/sign-in"></a></li>
    </ul>
    -->
    </div>
</header>
<!-- //header -->