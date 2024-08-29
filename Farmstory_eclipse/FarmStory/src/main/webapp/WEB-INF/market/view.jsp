<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>상품상세보기</title>
<link rel="stylesheet" href="../css/style_market_view.css">

        <!-- #main -->
        <main id="main" class="cf">
            <section class="mainIn cf">
                <div class="sub_bg">
                    <img src="../images/sub_top_tit2.png" alt="MARKET" class="sub_tit">
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
                            <img src="/FarmStory/images/sub_page_nav_ico.gif" alt="메뉴">
                            <span>HOME </span>
                            <span>장보기 </span>
                            <strong>장보기</strong> 
                        </p>
                    </nav>
                    <h3>기본정보</h3>
                    <div class="product_info">
                            <img src="/FarmStory/images/market_item_thumb.jpg" alt="30%세일 무농약재배" />
                         <div class="product_details">
                            <table>
                                <tr>
                                    <th>상품명</th>
                                    <td class="product">${productDto.pName}</td>
                                </tr>
                                <tr>
                                    <th>상품코드</th>
                                    <td class="product">${productDto.pNo}</td>
                                </tr>
                                <tr>
                                    <th>배송비</th>
                                    <td class="deliver">${productDto.delivery}원  <span>3만원 이상 무료배송</span></td>
                                </tr>
                                <tr>
                                    <th>판매가격</th>
                                    <td class="sell_price">${productDto.price}</td>
                                </tr>
                                <tr>
                                    <th>구매수량</th>
                                    <td class="count">
                                        <input type="number" value="1" id="numberInput"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>합계</th>
                                    <td class="sum" id="totalPrice">${productDto.price}</td>
                                </tr>
                            </table>
                             <div class="buttons">
                                <a href="#" type="button" class="add_to_cart">장바구니</a>
                                <a href="/FarmStory/market/order.do?pNo=${productDto.pNo}"  type="button" class="buy_now">바로구매</a>
                            </div> <!-- .buttons -->
                        </div> <!-- .product_info -->
                    </div>
                    <h3>상품설명</h3>
                    <div class="sample"><img src="/FarmStory/images/market_detail_sample.jpg" alt="IMAGE SAMPLE"></div>
                    <h3>배송정보</h3>
                    <p class="sms">입금하신 이후 택배송장번호는 SMS(문자서비스)를 통해 고객님께 안내해드립니다.</p>
                    <h3>교환/반품</h3>
                    <table class="table_change">
                        <colgroup>
                            <col style="width: 28.56%;">
                            <col style="width: 71.44%;">
                        </colgroup>
                        <tbody>
                            <tr>
                                <th><label>교환 반품이 가능한 경우</label></th>
                                <td>
                                    팜스토리 상품에 하자가 있거나 불량인 경우<br>
                                    채소, 과일, 양곡등의 식품은 만1일 이내<br>
                                    기타 상품은 수령일로부터 영업일 기준 일주일 이내<br>
                                    받으신 상품이 표시사항과 다른 경우에는 받으신 날로부터 일주일 이내
                                </td>
                            </tr>
                            <tr>
                                <th><label>교환 반품이 불가능한 경우</label></th>
                                <td>
                                    신선 식품의 경우 단순히 마음에 들지 않는 경우<br>
                                    단순 변심으로 상품이 가치가 훼손돼서 판매가 어려운 경우
                                </td>
                            </tr>
                    </table>
                    </div><!-- .articleIn -->
                </article><!-- .article -->
            </section>
        </main><!-- #main -->
        <script>
		const numberInput = document.getElementById('numberInput');
		const totalPrice = document.getElementById('totalPrice');
		
		numberInput.addEventListener('input', () => {
			
		const inNum = numberInput.value;
			
		totalPrice.innerText = inNum * ${productDto.price};
			
		});
	</script>
<%@ include file="../_footer.jsp" %>
