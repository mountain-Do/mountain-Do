<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/css/issue-list.css">
    <%@ include file="include/static-head.jsp" %>
</head>

<body>

    <%@ include file="include/header.jsp" %>

    <!-- 글 영역 -->
    <div class="main-img"></div>
    <div class="review-wrapper">

        <section class="review-main-wrapper">
            <div class="title-wrapper">
                <div class="review-main-title">산악 이슈</div>
                <div class="review-sub-title">요즘 가장 핫한 산악 정보는?</div>
            </div>
            <div class="hide-admin">
                <div class="hide-admin">
                    <div class="hide-admin-text">공지 숨기기</div>
                    <input type="range" max="1" id="choice" name="choice">
                </div>
            </div>
        </section>

        <section class="division-wrapper">
            <div class="division-boardNo">게시글 번호</div>
            <div class="division-title">제목</div>
            <div class="division-writer">작성자</div>
            <div class="division-writen-date">작성일</div>
            <div class="division-view-count">조회</div>
            <div class="division-like-it">좋아요</div>
        </section>

        <!-- 작성글 영역 -->
        <section class="board-wrapper">


            <c:forEach var="is" items="${issueList}">
                <!-- 공지글 영역 -->
                <c:if test="${is.id == admin}">
                    <div class="board-container">
                        <div class="board-boardNo">
                            <div class="admin-write">공지</div>
                        </div>
                        <div class="board-title admin-write-title">${is.title}</div>
                        <div class="board-writer">관리자</div>
                        <div class="board-writen-date">${is.date}</div>
                        <div class="board-view-count">${is.viewCount}</div>
                        <div class="board-like-it">좋아요 수</div>
                    </div>
                </c:if>

                <!-- 사용자글 영역 -->
                <c:if test="${is.id != admin}">
                    <div class="board-container">
                        <div class="board-boardNo">${is.boardNo}</div>
                        <div class="board-title">${is.title}</div>
                        <div class="board-writer">${is.id}</div>
                        <div class="board-writen-date">${is.date}</div>
                        <div class="board-view-count">${is.viewCount}</div>
                        <div class="division-like-it">좋아요 수</div>
                    </div>
                </c:if>
            </c:forEach>

            <button class="write-btn">글쓰기</button>
        </section>
    </div>

    <!-- 페이지 버튼 영역 -->
    <nav aria-label="Page navigation example">
        <ul class="pagination pagination-lg pagination-custom">


            <c:if test="${maker.page.pageNo != 1}">
                <li class="page-item"><a class="page-link"
                        href="/board/list?pageNo=1&clubRecruitType=${s.clubRecruitType}">&lt;&lt;</a></li>
            </c:if>

            <c:if test="${maker.prev}">
                <li class="page-item"><a class="page-link"
                        href="/board/list?pageNo=${maker.begin - 1}&clubRecruitType=${s.clubRecruitType}">prev</a></li>
            </c:if>

            <c:forEach var="i" begin="${maker.begin}" end="${maker.end}">
                <li data-page-num="${i}" class="page-item">
                    <a class="page-link" href="/board/list?pageNo=${i}&clubRecruitType=${s.clubRecruitType}">${i}</a>
                </li>
            </c:forEach>


            <c:if test="${maker.next}">
                <li class="page-item"><a class="page-link"
                        href="/board/list?pageNo=${maker.end + 1}&clubRecruitType=${s.clubRecruitType}">next</a></li>
            </c:if>

            <c:if test="${maker.page.pageNo != maker.finalPage}">
                <li class="page-item"><a class="page-link"
                        href="/board/list?pageNo=${maker.finalPage}&clubRecruitType=${s.clubRecruitType}">&gt;&gt;</a>
                </li>
            </c:if>
        </ul>
    </nav>


    <script>
        //현재 위치한 페이지에 active 스타일 부여하기
        function appendPageActive() {

            // 현재 내가 보고 있는 페이지 넘버
            const curPageNum = '${maker.page.pageNo}';
            console.log("현재페이지: ", curPageNum);

            // 페이지 li태그들을 전부 확인해서 
            // 현재 위치한 페이지 넘버와 텍스트컨텐츠가 일치하는
            // li를 찾아서 class active 부여
            const $ul = document.querySelector('.pagination');

            for (let $li of [...$ul.children]) {
                if (curPageNum === $li.dataset.pageNum) {
                    $li.classList.add('active');
                    break;
                }
            }

        }

        // // 셀렉트옵션 검색타입 태그 고정
        // function fixSearchOption() {
        //     const $select = document.getElementById('search-type');

        //     for (let $opt of [...$select.children]) {
        //         if ($opt.value === '${s.type}') {
        //             $opt.setAttribute('selected', 'selected');
        //             break;
        //         }
        //     }
        // }

        appendPageActive();
        // fixSearchOption();
    </script>
</body>

</html>