<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%@ include file="../include/static-head.jsp" %>
    <link rel="stylesheet" href="/assets/css/club-list.css">
</head>

<body>

    <%@ include file="../include/header.jsp" %>

    <section class="club-container">
        <form action="/club/list" method="get" id="select-form">
            <div class="club-category-wrapper">
                <div class="write-btn-wrapper">
                    <div class="category-select">
                        <select class="form-select" name="clubRecruitType" id="clubRecruitType"
                            onchange="document.getElementById('select-form').submit()">
                            <option value="전체">전체</option>
                            <option value="정기모임">정기모임</option>
                            <option value="소모임">소모임</option>
                        </select>
                    </div>
                    <button class="write-btn">글쓰기</button>
                </div>
        </form>
        
        <div class="club-wrapper">
            <c:forEach var="b" items="${bList}">
                <div class="club-list-container" data-bno="b.clubBoardNo">
                    <div class="club-title">${b.clubTitle}</div>
                    <div class="icon-detail">
                        <div class="mountain-sec">
                            <img src="/assets/jpg/mountain.png" alt="" class="mountain-icon">
                            <p class="mountain-text">4명</p>
                        </div>
                        <div class="mountain-sec">
                            <img src="/assets/jpg/people.png" alt="" class="people-icon">
                            <p class="people-text">${b.clubRecruitType}</p>
                        </div>
                        <div class="mountain-sec">
                            <img src="/assets/jpg/calendar.png" class="calendar-icon">
                            <p class="calendar-text">${b.clubRegdate}</p>
                        </div>
                        <div class="mountain-sec">
                            <img src="/assets/jpg/location.png" alt="" class="location-icon">
                            <p class="location-text">${b.clubArea}</p>
                        </div>
                    </div>
                    <div class="club-content">
                        ${b.clubContent}
                    </div>

                    <div class="now-count-wrapper">
                        <div class="now-text">현재 모집인원</div>
                        <div class="now-count">1/4<p id="lower-size">명</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <ul class="pagination">
            <c:if test="${maker.page.pageNo != 1}">
                <li class="page-item"><a class="page-link"
                        href="/club/list?pageNo=1&clubRecruitType=${s.clubRecruitType}">&lt;&lt;</a></li>
            </c:if>

            <c:if test="${maker.prev}">
                <li class="page-item"><a href="/club/list?pageNo=${maker.begin-1}&clubRecruitType=${s.clubRecruitType}"
                        class="page-link">prev</a>
                </li>
            </c:if>

            <c:forEach var="i" begin="${maker.begin}" end="${maker.end}">
                <li data-page-num="${i}" class="page-item">
                    <a class="page-link" href="/club/list?pageNo=${i}&clubRecruitType=${s.clubRecruitType}">${i}</a>
                </li>
            </c:forEach>

            <c:if test="${maker.next}">
                <li class="page-item"><a href="/club/list?pageNo=${maker.end+1}&clubRecruitType=${s.clubRecruitType}"
                        class="page-link">next</a></li>
            </c:if>

            <c:if test="${maker.page.pageNo != maker.finalPage}">
                <li class="page-item"><a class="page-link"
                        href="/club/list?pageNo=${maker.finalPage}&clubRecruitType=${s.clubRecruitType}">&gt;&gt;</a>
                </li>
            </c:if>

    </section>

    <script>
        const $clubList = document.querySelector('.club-wrapper');
        $clubList.addEventListener('click', e =>{
            const bno = e.target.closest('div.club-list-container').dataset.bno;
            console.log(bno);
            // 상세조회 요청 보내기
            window.location.href = '/club/clubDetail?bno=' + bno + '&pageNo=${s.pageNo}&clubRecruitType=${s.clubRecruitType}';
        });

        $clubList.addEventListener('click', e => {
            const bno = e.target.closest('')
        })
        const clubListWrapper = document.querySelector('.club-list-container');

        clubListWrapper.addEventListener('click', function () {
            this.classList.toggle('clicked');
        });

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

        appendPageActive();

        // select 버튼 고정
        function fixSearchOption() {
            const $select = document.getElementById('clubRecruitType');

            for (let $opt of [...$select.children]) {
                if ($opt.value === '${s.clubRecruitType}') {
                    $opt.setAttribute('selected', 'selected');
                    break;
                }
            }
        }
        fixSearchOption();
    </script>

</body>

</html>