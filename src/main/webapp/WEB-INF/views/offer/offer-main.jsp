<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="../include/static-head.jsp" %>
    <link rel="stylesheet" href="/assets/css/offer.css">

    <title>Mountain-Do</title>
    <style>
        /* 추후 js 걸어야 함 */
        .offer-category-select li:nth-child(1) {
            background: #b7d15a;
        }

        .offer-category-select li:nth-child(1) a {
            color: #fff;
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <%@ include file="../include/header.jsp" %>
    <section class="offer-wrapper">

        <!-- offer header -->
        <div class="header-title-wrapper">
            <div class="title-wrapper">
                <div class="offer-main-title">추천 정보</div>
                <div class="offer-sub-title">보다 행복한 산행이 되시도록 산행길과 맛집을 추천해드려요.</div>
            </div>
            <div class="offer-category-select">
                <ul class="category">
                    <li id="offern1"><a href="/offer/offer-main">이달의 산행 추천</a></li>
                    <li id="offern2"><a href="/offer/offer-eat">코스별 맛집 추천</a></li>
                    <!-- <li id="offern3"><a href="">50대 명산 추천</a></li> -->
                </ul>
            </div>
        </div>
        <main>
            <div class="container">

                <!-- 관리자 권한 -->
                <button class="article-write-btn">글쓰기</button>

                <!-- article main -->
                <section class="article article-header">
                    <h2 class="article-title">이달에 가기 좋은 산 추천!</h2>
                    <!-- <p class="article-header-img"><img src="https://image.istarbucks.co.kr/common/img/coffee/coffeeCultivation_info_img01.jpg" alt="산 이미지"></p> -->
                    <div class="article-content header-content">요즘 떠오르는 건강 키워드가 바로 '등산'이죠!
                        빌딩과 사람으로 가득한 우리나라 수도 서울 곳곳에도 오르기 좋은 푸르른 산이 많다는 점 알고 계셨나요?
                        이번 주말은 봄꽃으로 가득한 등산로를 걸으며 힐링하는 건 어떨까요.
                        한 걸음 한 걸음 여유롭게 올라 정상에 도착하면, 서울의 아름다운 봄 풍경을 눈에 한아름 담을 수 있을 거예요!
                        &nbsp;&nbsp;(*여행 정보 및 산 이미지 출처: 서울시 공식 관광정보 ).</div>
                </section>

                <hr style="border: 1px solid #d0d0d0;">
                <section class="article">
                    <h2 class="article-title">${text.offerTitle1}</h2>

                    <!-- <img src="https://t1.daumcdn.net/cfile/tistory/99F88E3B5FB9E7A418" alt="인왕산 이미지"> -->
                    <img src="/local${image.get(0).offerImage}" alt="첫번째 이미지" class="article-image">

                    <p class="article-content">${text.offerContent1}</p>
                </section>

                <section class="article">
                    <h2 class="article-title">${text.offerTitle2}</h2>
                    <img src="/local${image.get(1).offerImage}"
                        alt="응봉산 이미지" class="article-image">
                    <p class="article-content">${text.offerContent2}</p>
                </section>
                <section class="article">
                    <h2 class="article-title">${text.offerTitle3}</h2>
                    <img src="/local${image.get(2).offerImage}" alt="아차산 이미지"
                        class="article-image">
                    <p class="article-content">${text.offerContent3}</p>
                </section>

                <section class="article">
                    <h2 class="article-title">${text.offerTitle4}</h2>
                    <img src="/local${image.get(3).offerImage}"
                        alt="청계산 이미지" class="article-image">
                    <p class="article-content">${text.offerContent4}</p>
                </section>
            </div>
        </main>
    </section>
    <script>

         // 글쓰기 버튼
         function goToOfferWritePage() {
            location.href = '/offer/offer-writer-editor';
        }

        const offerWriteButton = document.querySelector('.article-write-btn');
        offerWriteButton.addEventListener('click', goToOfferWritePage);
        
        // var links = document.querySelectorAll(".offer-category-select a");

        // var linkBackgrounds = {};

        // for (var i = 0; i < links.length; i++) {
        //   var link = links[i];
        //   linkBackgrounds[link.href] = {
        //     previousBackground: window.getComputedStyle(link).backgroundColor
        //   };

        //   link.addEventListener("click", function() {
        //     var currentBackground = window.getComputedStyle(this).backgroundColor;
        //     this.style.backgroundColor = "gray";
        //     linkBackgrounds[this.href].previousBackground = currentBackground;
        //   });

        //   link.addEventListener("mouseleave", function() {
        //     this.style.backgroundColor = linkBackgrounds[this.href].previousBackground;
        //   });
        // }
    </script>
</body>

</html>