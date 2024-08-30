<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<title>장바구니</title>
<link rel="stylesheet" href="../css/style_cart.css">

<script>
	window.onload = function(){
	let setDelete = new Set();
	const btnSd = document.getElementsByClassName('btnSD')[0];

	let chkboxes = document.querySelectorAll('.checkbox');

	chkboxes.forEach(function(checkbox) {
	    checkbox.addEventListener('click', function() {
	        if(this.checked){
	        	setDelete.add(this.value);
	        }else{
	        	setDelete.delete(this.value);
	        }
	    });
	});
	
	
	btnSd.addEventListener('click',function(e){
		e.preventDefault();
		
		let arr = [];
		setDelete.forEach(value => {
		    arr.push(value);
		});
		
		let formData = new FormData();
		
		arr.forEach(val => {
		    formData.append("pk", val);
		});
		// for (let key of formData.keys()) {
		// 	  console.log(key);
		// 	}
		formData.append("action", "delete");
		fetch('/FarmStory/market/cart.do', {
			method: 'POST',
			body: formData
	})
	.then(resp=>resp.json())
	.then(data=>{
		console.log(data);
		if(data.result > 0){
			alert('삭제되었습니다!');
			location.reload();
		}else{
			alert('실패하였습니다!');
		}
		
	})
	.catch(err=>{
		console.log(err);
	})
	
	});
	}
</script>

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
                <div class="articleIn cf">
                    <nav>
                        <h2><img src="/FarmStory/images/sub_nav_tit_cate2_tit1.png" alt="장보기"></h2>
                        <p class="location">
                            <img src="/FarmStory/images/sub_page_nav_ico.gif" alt="메뉴">
                            <span>HOME </span>
                            <span>장보기 </span>
                            <strong>장보기</strong> 
                        </p><!-- .location -->
                    </nav>
                    
                    <h3 class="tb_tit">장바구니 전체</h3><!-- .tb_tit -->
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
                        <c:if test="${prodCartDto eq null}">
                        <tr>
                            <td colspan="9" class="td_first">장바구니에 상품이 없습니다.</td>
                        </tr>
                        </c:if>
                        <c:forEach var="prodCartDto" items="${prodCartDto}">
                        <tr>
                            <td><input type="checkbox" class="checkbox" onclick=""  value="${prodCartDto.cartNo}"/></td>
                            <td><img src="/FarmStory/thumbs/product/${prodCartDto.sName}" alt="사과 샘플"/></td>
                            <td>${prodCartDto.prodCateName}</td>
                            <td>${prodCartDto.prodName}</td>
                            <td>${prodCartDto.prodQty}</td>
                            <td>${prodCartDto.discount}%</td>
                            <td>${prodCartDto.point}p</td>
                            <td>${prodCartDto.price}</td>
                            <td><strong>${service.total(prodCartDto)}</strong>원</td>
                        </tr>
                       </c:forEach>
                    </table><!-- .tb1 -->
                    <button class="btnSD"><a href="#">선택삭제</a></button>
                    <div class="order_final">
                        <table class="tb2">
                            <tr>
                                <th colspan="2">전체합계</th>
                            </tr>
                            <tr>
                                <td>상품수</td>
                                <td>${service.totalQty(prodCartDto)}개</td>
                            </tr>
                            <tr>
                                <td>상품금액</td>
                                <td>${service.totalPrice(prodCartDto)}원</td>
                            </tr>
                            <tr>
                                <td>할인금액</td>
                                <td>${service.totalDiscount(prodCartDto)}원</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td>${service.totalDelivery(prodCartDto)}원</td>
                            </tr>
                            <tr>
                                <td>포인트 적립</td>
                                <td>${service.totalPoint(prodCartDto)}p</td>
                            </tr>
                            <tr>
                                <td>전체주문금액</td>
                                <td>${service.realtotal(prodCartDto)}원</td>
                            </tr>
                        </table><!-- .tb2 -->
                        <button class="btn_order"><a href="/FarmStory/market/order.do?uid=${sessUser.uid}">주문하기</a></button>
                    </div><!-- .order_final -->

                </div><!-- .articleIn -->
            </article><!-- .article -->
        </section>
</main><!-- #main -->
    
<%@ include file="../_footer.jsp" %>

