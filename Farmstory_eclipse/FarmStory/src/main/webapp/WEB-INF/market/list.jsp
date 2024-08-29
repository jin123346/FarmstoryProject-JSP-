<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<title>상품목록</title>
<link rel="stylesheet" href="../css/style_market_list.css">

        <!-- #main -->
        <main id="main" class="cf">
            <section class="mainIn cf">
                <div class="sub_bg">
                    <img src="/FarmStory/images/sub_top_tit2.png" alt="MARKET" class="sub_tit">
                </div><!-- .sub_bg -->
                <aside class="aside">
                    <div class="sidebar">
                        <div class="aside_cate">
                            <img src="/FarmStory/images/sub_aside_cate2_tit.png" alt="Buying in the Market 장보기">
                        </div><!-- .aside_cate -->
                        <div class="aside_bg">
                            <ul class="cate_lnb">
                                <li> <a href="#">장보기</a></li>
                            </ul><!-- .cate_lnb -->
                        </div><!-- .aside_bg -->
                    </div><!-- .sidebar -->
                </aside><!-- .aside -->
                <article class="article">
                    <div class="articleIn">
                        <nav>
                            <h2>
                                <img src="/FarmStory/images/sub_nav_tit_cate2_tit1.png" alt="장보기">
                            </h2>
                            <p class="location">
                                <img src="../images/sub_page_nav_ico.gif" alt="메뉴">
                                <span>HOME </span>
                                <span>장보기 </span>
                                <strong>장보기</strong> 
                            </p>
                        </nav>
                        <ul class="tabs">
                            <li><a href="/FarmStory/market/list.do" class="tabs_item">전체(3)</a></li>
                            <li><a href="/FarmStory/market/list.do?cateName=과일" class="tabs_item item">과일</a></li>
                            <li><a href="/FarmStory/market/list.do?cateName=야채" class="tabs_item item">야채</a></li>
                            <li><a href="/FarmStory/market/list.do?cateName=곡류" class="tabs_item item">곡류</a></li>
                        </ul>
                        <table class="product_table">
                            <colgroup>
                                <col width="13.14%">    <!-- 이미지 -->
                                <col width="10.01%">    <!-- 종류 -->
                                <col width="40.93%">    <!-- 상품명 -->
                                <col width="12.02%">    <!-- 할인 -->
                                <col width="12.02%">    <!-- 포인트 -->
                                <col width="12.02%">    <!-- 판매가격 -->
                            </colgroup>
                            <thead>
                                <tr class="row">
                                    <th>이미지</th>
                                    <th>종류</th>
                                    <th>상품명</th>
                                    <th>할인</th>
                                    <th>포인트</th>
                                    <th>판매가격</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="productDto" items="${productDto}">
                                <tr>
                                    <td class="pic"><img src="../images/market_item1.jpg" alt="사과 500g"></td>
                                    <td class="type">${productDto.prodCateName}</td>
                                    <td class="pro_name"><a href="/FarmStory/market/view.do?pNo=${productDto.pNo}&&uid=${sessUser.uid}">${productDto.pName}</a></td>
                                    <td class="sale">${productDto.discount}%</td>
                                    <td class="point">${productDto.point}p</td>
                                    <td class="price"><strong>${(productDto.price) - service.disPrice(productDto)}원</strong><span class="original_price">${productDto.price}원</span></td>
                                </tr>
                           	</c:forEach>
                            </tbody>
                        </table>
                        <div class="pages">
                            <ul>
                                <li>
                                	<c:set var="page" value="1"/>
                                	<c:if test="${page ne pageGroupP.start}">
                                		<a href="/FarmStory/market/list.do?pg=${pageGroupP.start - 1}" class="no current">&#60;</a>
                           			</c:if>
                           		</li>
                                <li>
                                	<c:forEach var="i" begin="${pageGroupP.start}" end="${pageGroupP.end}">
                                		<a href="/FarmStory/market/list.do?pg=${i}&&" class="no">[${i}]</a>
                                	</c:forEach>
                                </li>
                                <li>
                                	<c:set var="page" value="${lastPageNum}" />
                                	<c:if test="${page > pageGroupP.end }">
                               			<a href="/FarmStory/market/list.do?pg=${pageGroupP.end + 1}" class="no last_no">&#62;</a>
                               		</c:if>
                                </li>
                            </ul>
                        </div>
                    </div><!-- .articleIn -->
                </article><!-- .article -->
            </section>
        </main><!-- #main -->
<%@ include file="../_footer.jsp" %>