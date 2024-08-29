<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<title>찾아오시는길</title>
<link rel="stylesheet" href="../../css/introduction/direction.css">
<main id="main cf">
    <section class="mainIn cf">
        <div class="sub_bg">
            <span class="sub_tit"><img src="../images/sub_top_tit1.png" alt=""></span><!-- .sub_tit -->
        </div>
         <aside class="aside">
            <div class="sidebar">
                <div class="aside_cate">
                    <img src="../images/sub_aside_cate1_tit.png" alt="커뮤니티">
                </div><!-- .aside_cate -->
                <div class="aside_bg">
                    <ul class="cate_lnb">
                        <li> <a href="/FarmStory/intro/introduction.do">인사말</a></li>
                        <li> <a href="/FarmStory/intro/direction.do">찾아오는길</a></li>
                  
                    </ul><!-- .cate_lnb -->
                </div><!-- .aside_bg -->
            </div><!-- .sidebar -->
        </aside><!-- .aside -->
        
        <article class="article">
            <div class="articleIn">
                <nav>
                    <h2>
                        <img src="../images/sub_nav_tit_cate1_tit2.png" alt="찾아오시는길">
                    </h2>
                    <p class="location">
                        <img src="../images/sub_page_nav_ico.gif" alt="메뉴">
                        <span>HOME </span>
                        <span>팜스토리소개 </span>
                        <strong>찾아오시는길</strong> 
                    </p>
                </nav>
                <div class="direction cf">
                    <ul>
                        <li>
                            <span class="txt1">팜스토리</span><br>
                            <p>
                                주소 : 경기도 이천시 잘한다구 신난다동 123<br>
                                전화 : 010-2345-7890  
                            </p>
                        </li>
                        <li>
                            <span class="txt1">찾아오시는 길</span>
                            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1185526bec189e0f0c285b8af341b4a5"></script>
                            <div id="map" style="width:760px;height:400px;"></div>
                            <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
                            <script>
                            var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
                                center : new kakao.maps.LatLng(35.179665, 129.0747635), // 지도의 중심좌표 
                                level : 3 // 지도의 확대 레벨 
                            });
                            
                            var markerPosition  = new kakao.maps.LatLng(35.179665, 129.0747635); 

                          // 마커를 생성합니다
                          var marker = new kakao.maps.Marker({
                              position: markerPosition
                          });

                          // 마커가 지도 위에 표시되도록 설정합니다
                          marker.setMap(map);
                          var mapTypeControl = new kakao.maps.MapTypeControl();

                        // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
                        // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
                        map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

                        // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                        var zoomControl = new kakao.maps.ZoomControl();
                        map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
                        
                          
	</script>
	  
                        </li>
                    </ul>  
                </div><!--direction -->
            </div><!-- .articleIn -->
        </article><!-- .article -->
    </section>
</main><!-- #main -->
<%@ include file="../_footer.jsp" %>