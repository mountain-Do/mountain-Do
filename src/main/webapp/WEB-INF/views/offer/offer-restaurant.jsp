<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/css/offer.css">
    <link rel="stylesheet" href="/assets/css/common.css">
    <%@ include file="../include/static-head.jsp" %>

    <title>Mountain-Do Offer</title>
    <style>

        /* 맛집 추천 독립 css */
    .article-resto {
        margin: 100px auto 50px;
    }

    .article-resto .article-wrap {
        display: flex;
        justify-content: flex-start;
        font-size: 18px;
    }
    
    .article-wrap div {
        padding-left: 15px;
        width: 450px;
        line-height: 1.9;
    }
    .article-resto .article-wrap ul {
        margin: 10px auto 20px;
    }
    /* 추후 js 걸어야 함 */
    .offer-category-select li:nth-child(2) {
    background: #959595;
    }

    .offer-category-select li:nth-child(2) a {
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
                    <li><a href="offer-menu.html">이달의 산행 추천</a></li>
                    <li><a href="offer-restaurant.html">코스별 맛집 추천</a></li>
                    <li><a href="offer-top50.html">50대 명산 추천</a></li>
                </ul>
            </div>
        </div>
        <main>
            <div class="container">

                <!-- 관리자 권한 -->
                <button class="article-write-btn">글쓰기</button>

                <!-- article main -->
                <section class="article article-header">
                    <h2 class="article-title">코스별 맛집 추천!</h2>
                    <!-- <p class="article-header-img"><img src="https://image.istarbucks.co.kr/common/img/coffee/coffeeCultivation_info_img01.jpg" alt="산 이미지"></p> -->
                    <div class="article-content header-content">코로나 이후 등산객과 캠핑족들이 늘어났다고 하죠!
                        마스크를 끼고 등산해야하는건 불편하지만 그래도 자연이라는 오픈된 공간이기에 많은 분들이 등산에 입문 중입니다.
                        오늘은 등린이들도 충분히 오를 수 있는 난이도 하의 등산 코스와 등산을 하는 이유인 그 주변 맛집들을 소개해볼게요.</div>
                </section>

                <hr style="border: 1px solid #d0d0d0;">

                <!--resto article main -->
                <section class="article-resto">
                    <h2 class="article-title"> 01. 아차산 - 용마산</h2>
                    <img src="https://s3-ap-northeast-2.amazonaws.com/mp-seoul-image-production/573810_1589184647514037.jpg?fit=around|600:*&crop=600:*;*,*&output-format=jpg&output-quality=80"
                    alt="원조할아버지 이미지" class="article-image">
                            <p class="article-content">
                                건대/군자/광진 : 원조할아버지손두부
                                아차산에 올라가는 이유는 바로 이곳. 줄 서서 먹는 두부 전문점을 소개합니다.
                                메뉴는 모두부, 순두부, 콩국수(계절메뉴)가 전부! 식사를 하기보다 막걸리를 곁들여 반주하러 오는 찐 술집 같은 공간에 가까워요.
                                하지만 여름철에는 식사로 제격인 고소한 콩국수가 있으니 걱정마세요.
                                콩국수 한그릇에 몽글몽글 부드러움이 일품인 순두부는 건강한 밥이자 안주가 될거예요.
                                특히 순두부에 간장을 챱챱 비비고 밥위에 얹어 먹어도 꿀맛!</p>
                </section>

                <section class="article">
                    <h2 class="article-title">02. 인왕산</h2>
                    <img src="https://s3-ap-northeast-2.amazonaws.com/mp-seoul-image-production/2903/908827_1577469472107_1065968?fit=around|600:*&crop=600:*;*,*&output-format=jpg&output-quality=80"
                        alt="응봉산 이미지" class="article-image">
                    <p class="article-content">코스: 경복궁역 - 인왕산 정상 - 자하문
                        소요시간: 약 2시간
                        서울 한 가운데에서 느끼는 자연! 근처에 서촌, 부암동 맛집이 수두룩한 건 덤이죠.<br>
                        종로 : 자하손만두
                        부암동 언덕길에 위치한 만두 전문점입니다.
                        가정집을 개조해 만든 식당으로 따뜻하고 정겨운 분위기가 좋아요.
                        커다란 통유리창에 산 능선이 쫙 보이는 뷰 맛집이기도 하죠. 인기 메뉴는 만둣국과 만두전골.
                        가격대가 꽤 높은 편이지만 정갈하고 정성이 가득 들어간 만두와 슴슴한 국물 맛에서 정직함이 느껴져요.
                        굉장히 심심한 편이라 호불호가 있겠지만 만두피와 만두 안에 두부, 숙주, 고기 등 재료 각각의 맛을 음미하면서 먹을 수 있는 요리예요.
                    </p>
                </section>
                <section class="article">
                    <h2 class="article-title">03. 청계산</h2>
                    <img src="https://s3-ap-northeast-2.amazonaws.com/mp-seoul-image-production/86993/pa13-xlazqls4e.jpg?fit=around|600:*&crop=600:*;*,*&output-format=jpg&output-quality=80"
                        alt="아차산 이미지" class="article-image">
                    <p class="article-content">코스: 청계산입구역 - 매봉 정상 - 청계산입구역
                        소요시간: 약 2시간 30분
                        흙산이라 등산화 없이도 충분히 오를 수 있는 등린이들의 성지! 내려와서 막거리 짠~할 생각하면 힘이 날거예요.<br>
                        양재동 : 소담채
                        등산 후에는 막걸리가 당기기 마련! 막걸리와 잘 어울리는 보리밥, 전, 도토리묵을 맛볼 수 있는 이곳을 소개해요.
                        청계산 등산객들이 자주 찾는 대표 맛집입니다.</p>
                </section>

                <section class="article">
                    <h2 class="article-title">04. 북한산</h2>
                    <img src="https://s3-ap-northeast-2.amazonaws.com/mp-seoul-image-production/651394_1591156264731419.jpg?fit=around|600:*&crop=600:*;*,*&output-format=jpg&output-quality=80"
                        alt="청계산 이미지" class="article-image">
                    <p class="article-content">코스: 구파발역 - 북한산성탐방지원센터 - 백운대 정상 - 구파발역
                        소요시간: 약 6시간
                        엄청난 바위산. 장갑은 필수! 로프를 잡고 바위를 오르는 부분이 힘들 수 있지만 그래도 초보자들이 중급으로 넘어가기 전에 마지막 관문으로 생각하면 좋을 코스랍니다.
                        힘들지만 그 어떤 곳보다 자연 경관은 최고예요!<br>
                        가평군 : 삼각산 머루집
                        맛있는녀석들 등산 특집편에도 소개된 이곳. 탱글함이 남다른 도토리묵을 맛볼 수 있는 곳입니다.

                        흑임자가 들어가 고소함이 배가 된 양념장 때문인지 일반적인 도토리묵이 아니라 굉장히 색다른 맛으로 느껴져요.</p>
                </section>
            </div>
        </main>
    </section>


</body>

</html>