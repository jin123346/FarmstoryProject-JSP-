<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<title>장바구니</title>

<!-- #main -->
<main id="main" class="cf">
	<section class="mainIn cf">
            <div class="sub_bg">
                <img src="../images/sub_top_tit2.png" alt="MARKET" class="sub_tit">
            </div><!-- .sub_bg -->
            <aside class="aside">
                <div class="sidebar">
                    <div class="aside_cate">
                        <img src="../images/sub_aside_cate2_tit.png" alt="Buying in the Market 장보기">
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
                            <img src="../images/sub_nav_tit_cate2_tit1.png" alt="장보기">
                        </h2>
                        <p class="location">
                            <img src="../images/sub_page_nav_ico.gif" alt="메뉴">
                            <span>HOME </span>
                            <span>장보기 </span>
                            <strong>장보기</strong> 
                        </p>
                    </nav>
                    
                    <span class="all">장바구니 전체(10)</span>
                    <table class="tb1">
                        <colgroup>
                            <col style="width: 11%">
                            <col style="width: 5%">
                            <col style="width: 10%">
                            <col style="width: 15%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                        </colgroup>
                        <tr>
                            <th><input type="checkbox" class="checkbox"/></th>
                            <th>이미지</th>
                            <th>종류</th>
                            <th>상품명</th>
                            <th>수량</th>
                            <th>할인</th>
                            <th>포인트</th>
                            <th>가격</th>
                            <th>소계</th>
                        </tr>
                        <tr>
                            <td colspan="9" class="td_first">장바구니에 상품이 없습니다.</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" class="checkbox"/></td>
                            <td><img src="../images/market_item1.jpg" alt="사과 샘플"/></td>
                            <td>과일</td>
                            <td>사과 500g</td>
                            <td>1</td>
                            <td>10%</td>
                            <td>40p</td>
                            <td>4,000</td>
                            <td><strong>3,600</strong>원</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td><img src="../images/market_item1.jpg" alt="사과 샘플"/></td>
                            <td>과일</td>
                            <td>사과 500g</td>
                            <td>1</td>
                            <td>10%</td>
                            <td>40p</td>
                            <td>4,000</td>
                            <td><strong>3,600</strong>원</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td><img src="../images/market_item1.jpg" alt="사과 샘플"/></td>
                            <td>과일</td>
                            <td>사과 500g</td>
                            <td>1</td>
                            <td>10%</td>
                            <td>40p</td>
                            <td>4,000</td>
                            <td><strong>3,600</strong>원</td>
                        </tr>
                    </table>
                    <button class="btnSD"><a href="#">선택삭제</a></button>
                    <div class="order_final">
                        <table class="tb2">
                            <tr>
                                <th colspan="2">전체합계</th>
                            </tr>
                            <tr>
                                <td>상품수</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>상품금액</td>
                                <td>27,000</td>
                            </tr>
                            <tr>
                                <td>할인금액</td>
                                <td>5,0000원</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td>5,0000원</td>
                            </tr>
                            <tr>
                                <td>포인트</td>
                                <td>4,000원</td>
                            </tr>
                            <tr>
                                <td>전체주문금액</td>
                                <td>22,000</td>
                            </tr>
                        </table>
                        <button class="btn_order"><a href="#">주문하기</a></button>
                    </div> <!-- .order_final-->

                </div><!-- .articleIn -->
            </article><!-- .article -->
        </section>
</main><!-- #main -->
    
<%@ include file="../_footer.jsp" %>