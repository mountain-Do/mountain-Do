<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/assets/css/offer.css">
    <link rel="stylesheet" href="/assets/css/common.css">
    <%@ include file="../include/static-head.jsp" %>

    <title>Mountain-Do Offer</title>
    <style>
        /* 추후 js 걸어야 함 */
        .offer-category-select li:nth-child(1) {
            background: #959595;
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
                    <li id="offern1"><a href="offer-menu.html">이달의 산행 추천</a></li>
                    <li id="offern2"><a href="offer-restaurant.html">코스별 맛집 추천</a></li>
                    <li id="offern3"><a href="">50대 명산 추천</a></li>
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
                    <h2 class="article-title">01. 인왕산</h2>
                    <img src="https://t1.daumcdn.net/cfile/tistory/99F88E3B5FB9E7A418" alt="인왕산 이미지"
                        class="article-image">
                    <p class="article-content">서울 도성이 남아있는 인왕산의 정상에 서면, 경복궁을 중심으로 인왕산/내산/남산/백악산 전경을 한 눈에 담을 수 있다고 합니다.
                        사직터널에서 출발해 정상을 찍고 부암동 쪽으로 하산하는 코스가 가장 인기 있다고 해요.
                        등린이들의 인증샷 맛집인 만큼, 초심자들도 멋진 서울 풍경도 감상할 겸 가볍게 다녀오기 좋은 산입니다.</p>
                </section>

                <section class="article">
                    <h2 class="article-title">02. 응봉산</h2>
                    <img src="https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202203/28/6bd92c01-5fb4-46ac-8f94-525847271b1c.jpg"
                        alt="응봉산 이미지" class="article-image">
                    <p class="article-content">응봉산은 근린공원으로 지정되어 있으며, 주변 풍경이 아름다워서 기념사진을 남기기에도 좋은 산입니다.
                        난이도가 높지 않아 초심자들도 천천히 걸어서 오를 수 있습니다.
                        특히 응봉산은 야경이 아름답기로 유명한데요. 응봉산 정상 근처에 위치한 팔각정은 그 자체로도 아름답지만,
                        밤에 방문하면 반짝반짝 빛나는 서울 야경을 감상하기에 좋은 장소이기도 하답니다.</p>
                </section>
                <section class="article">
                    <h2 class="article-title">03. 아차산</h2>
                    <img src="https://tong.visitkorea.or.kr/cms/resource/57/2661757_image2_1.jpg" alt="아차산 이미지"
                        class="article-image">
                    <p class="article-content">아차산은 서울에서 가장 동쪽에 위치한 산으로, 한강과 도시가 어우러진 풍경을 즐길 수 있는 곳입니다.
                        등산로가 잘 갖춰져 있어, 발 밑에 핀 아름다운 봄꽃들을 마음 편히 감상하며 오를 수 있는 산이기도 하죠.
                        언제 올라도 좋은 산이지만, 아차산은 해 뜰 무렵 오르면 가장 아름다운 해돋이 명소이기도 하답니다.
                        교통편도 편리하고, 등산로도 완만해서 모두가 쉽게 도전할 수 있는 산입니다.
                        아차산 일출 포인트는 정상(4보루)과 산 중턱에 위치한 해맞이 광장이라는 점 참고해주세요!</p>
                </section>

                <section class="article">
                    <h2 class="article-title">04. 청계산</h2>
                    <img src="https://mblogthumb-phinf.pstatic.net/MjAxOTA5MTJfODMg/MDAxNTY4MjUxNDQ5MTMw.dmj7Da0SA5vmZy_ECPIHt2UVOjIdDZxgNsBx_GI1rFAg.ZGzIQN7Sahaspid6b4dcxtYNrN3R5mPTxWv7-57OeJgg.JPEG.totaltax/190910_%EC%83%81%EC%A3%BC_%EC%B2%AD%EA%B3%84%EC%82%B0_(45).jpg?type=w800"
                        alt="청계산 이미지" class="article-image">
                    <p class="article-content">청계산은 서울의 근교에 위치한 산 중 남쪽에 위치한 산입니다.
                        복잡하고 험한 등산길이 아니라 산책로와 유사한 난이도로, 초심자들도 많이 찾는 산이기도 해요.
                        정상에 오르면 서울의 전경을 한눈에 담을 수 있답니다.
                        매바위 옆쪽에 포토존이 있어 인증샷을 남기기에도 좋을 거예요!</p>
                </section>
            </div>
        </main>
    </section>
    <script>
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