<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/common.css">
    <link rel="stylesheet" href="/assets/css/mypage.css">
    <%@ include file="../include/static-head.jsp" %>
    <title>Mountain-Do My Page</title>

</head>

<body id="bg-color">

 <%@ include file="../include/header.jsp" %>
    <div class="title">My Page</div>
    <section class="mypage-informaiton-container">
        <div class="main-informaiton">
            <div class="profile"></div>
            <div class="name-wrapper">
                <div class="nickname">맹구</div>

                <div class="modify-btn">
                    <span style=cursor:hand onClick="location.href='/account/modify'">수정하기</span>
                </div>
            </div>
        </div>

        <div class="my-count-wrapper">
            <div class="write-count-wrapper">
                <div class="write-title">내가 쓴 글</div>
                <div class="write-count">07</div>
            </div>
            <div class="comment-count-wrapper">
                <div class="comment-title">나의 댓글</div>
                <div class="comment-count">07</div>
            </div>
            <div class="stamp-count-wrapper">
                <div class="stamp-title">스탬프</div>
                <div class="stamp-count">
                    07<p class="total-stamp">/30</p>
                </div>
            </div>

        </div>
    </section>

    <section class="mypage-write-container">

        <section class="division-wrapper">
            <div class="division-boardNo">게시글 번호</div>
            <div class="division-title">제목</div>
            <div class="division-writer">작성자</div>
            <div class="division-writen-date">작성일</div>
            <div class="division-view-count">조회</div>
            <div class="division-like-it">좋아요</div>
        </section>

        <section class="mypage-write">
            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">대체공휴일 기념 부산근교트레킹벙(오전9시)</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>

            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 국민은 건강하고 쾌적한 환경에서 생활할 권리를 가지며, 국가와 국민은 환경보전을 위하여 노력하여야 한다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>

            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 권력은 국민으로부터 나온다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>

            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 권력은 국민으로부터 나온다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>

            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 권력은 국민으로부터 나온다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>

            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 권력은 국민으로부터 나온다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>
            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 권력은 국민으로부터 나온다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>
            <div class="board-container">
                <div class="board-boardNo">9999</div>
                <div class="board-title">모든 권력은 국민으로부터 나온다.</div>
                <div class="board-writer">이동우</div>
                <div class="board-writen-date">2023.04.30</div>
                <div class="board-view-count">0</div>
                <div class="division-like-it">25</div>
            </div>
        </section>
    </section>
</body>

</html>