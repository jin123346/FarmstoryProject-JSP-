<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<title>주문하기</title>
<link rel="stylesheet" href="../css/order.css">  
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

function postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                //document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zip').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();
} // end of kakaozip

window.onload = function(){
	
	const point = document.getElementsByClassName('point')[0];
	const pointUse = document.getElementById('pointUse');
	const cart = document.getElementsByClassName('add_to_cart')[0];
	const buyNow = document.getElementsByClassName('buy_now')[0];
	
	const point_btn = document.getElementsByClassName('point_btn')[0];
	const btn_order = document.getElementsByClassName('btn_order')[0];

	// 포인트 사용 클릭시 버튼 들어가기
	point_btn.addEventListener('click', (e) => {
		e.preventDefault();
		
	const inNum = point.value;
		
	if(${userDto.point} < inNum){
		alert('포인트가 모자랍니다!');		
	}else{
		pointUse.innerText = inNum + "p";	
	}
	});
	
	
	btn_order.addEventListener('click', function(e){
		e.preventDefault();
	// input 이벤트 용도
	let recepit = document.getElementsByClassName('recepit')[0];
	let recHp = document.getElementsByClassName('rec_hp')[0];
	let recZip = document.getElementsByClassName('post_sch')[0];
	let recAddr1 = document.getElementsByClassName('addr1')[0];
	let recAddr2 = document.getElementsByClassName('addr2')[0];
	let payment = document.querySelector('input[name="pay"]:checked'); 
	const orderDesc = document.getElementsByClassName('etc')[0];
	
	console.log(payment.value);
	console.log(orderDesc.value);

	// 값 집어넣기
	let recepitV = document.getElementById('recepit');
	let recHpV = document.getElementById('recHp');
	let recZipV = document.getElementById('recZip');
	let recAddr1V = document.getElementById('recAddr1');
	let recAddr2V = document.getElementById('recAddr2');
	let paymentV = document.getElementById('payment');
	let orderDescV = document.getElementById('orderDesc');
	
		// 받는사람
			
			recepitV.value = recepit.value;
		// 전화번호
			
			recHpV.value = recHp.value;
		// 우편번호
			
			recZipV.value = recZip.value;
		// 주소 1
			
			recAddr1V.value = recAddr1.value;
		// 주소 2
			
			recAddr2V.value = recAddr2.value;
		// 결제방법
			paymentV.value =  payment.value;
		// 주문 기타 정보

		orderDescV.value = orderDesc.value;
		
		
		let form = document.getElementById('formData');
		let formData = new FormData(form);
		formData.append("action","insert");
			console.log(formData);
			
			fetch('/FarmStory/market/order.do', {
					method: 'POST',
					body: formData
			
			})
			.then(resp=>resp.json())
			.then(data=>{
				console.log(data);
				if(data.result > 0){
					alert('결제 정보가 등록되었습니다!');
				}else{
					alert('결제 정보 등록에 실패하였습니다');
				}
				
			})
			.catch(err=>{
				console.log(err);
			});
	})
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
                        <ul class="cate_lnb_real">
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
                    
                    <h3 class="tb_tit">주문상춤 전체</h3><!-- .tb_tit -->
                    <table class="tb1">
                        <colgroup>
                            <col style="width: 10%">
                            <col style="width: 12%">
                            <col style="width: 28%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                            <col style="width: 10%">
                        </colgroup>
                        <tr>
                            <th>이미지</th>
                            <th>종류</th>
                            <th>상품명</th>
                            <th>수량</th>
                            <th>할인</th>
                            <th>포인트</th>
                            <th>가격</th>
                            <th>소계</th>
                        </tr>
                        <c:forEach var="prodCartDto" items="${prodCartDto}">
	                        <tr>
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

                    
                    <div class="order_info cf">
                        <h4 class="order_tit">주문정보 입력</h4>
                        <table class="order_tb cf">
                            <colgroup>
                                <col style="width: 23.52%">
                                <col style="width: 76.48%">
                            </colgroup>
                            <tr>
                                <th>주문자</th>
                                <td>
                                    <input type="text" class="uid" placeholder="${userDto.name}" readonly>
                                </td>
                            </tr>
                            <tr>
                                <th>휴대폰</th>
                                <td>
                                    <input type="text" class="hp" placeholder="${userDto.hp}" readonly>
                                </td>
                            </tr>
                            <tr class="use cf">
                                <th>포인트사용</th>
                                <td class="use_point cf">
                                    <input type="text" class="point" placeholder="${userDto.point}p 만큼 사용 가능합니다.">
                                    <a href="#" class="point_btn">사용하기</a><br>
                                    <div></div>
                                </td>
                            </tr>
                            <tr>
                                <th>받는분</th>
                                <td><input type="text" class="recepit"  placeholder=""></td>
                            </tr>
                            <tr>
                                <th>연락처</th>
                                <td><input type="text" class="rec_hp" placeholder=""></td>
                            </tr>
                            <tr>
                                <th class="delivery_addr">배송주소</th>
                                <td class="cf">
                                    <input type="text" name="zip" id="zip" class="post_sch" placeholder="우편번호" title="우편번호 검색칸"  readonly/>
                                    <a href="#" class="btnZip" onclick="postcode()"><img src="../images/btn_post_search.gif" alt="우편번호 검색" class="post_sch_btn"></a>
                                    <input type="text" class="addr1" id="addr1" placeholder="기본주소 검색">
                                    <input type="text" class="addr2" id="addr2" placeholder="상세주소 입력">
                                    
                                </td>
                            </tr>
                            <tr>
                                <th>결제방법</th>
                                <td class="chkboxes" >
                                    <input type="radio" name="pay" id="check" value="1"><label for="check"></label>
                                    계좌이체
                                    <input type="radio" name="pay" class="" placeholder="" value="2">신용카드
                                    <input type="radio" name="pay" class="" placeholder="" value="3">체크카드
                                    <input type="radio" name="pay" class="" placeholder="" value="4">휴대폰
                                </td>
                            </tr> 
                            <tr>
                                <th >기타</th>
                                <td ><input type="textarea" placeholder="" class="etc"></td>
                            </tr>
                        </table>
                    </div> <!-- .order_info -->

                    <div class="order_final cf">
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
                                <td>포인트 사용</td>
                                <td id="pointUse">0p</td>
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
                        <button class="btn_order"><a href="#">주문하기</a></button>
                        
                        <form id="formData">
							<input type="hidden" name="uid" value="${userDto.uid}" id="uid">
							<input type="hidden" name="recepit" value="" id="recepit">
							<input type="hidden" name="recHp" value="" id="recHp">
							<input type="hidden" name="recZip" value="" id="recZip">
							<input type="hidden" name="recAddr1" value="" id="recAddr1">
							<input type="hidden" name="recAddr2" value="" id="recAddr2">
							<input type="hidden" name="payment" value="" id="payment">
							<input type="hidden" name="orderDesc" value="" id="orderDesc">
						</form>
                        
                    </div><!-- .order_final -->

                </div><!-- .articleIn -->
            </article><!-- .article -->
        </section>
    </main><!-- #main -->
<%@ include file="../_footer.jsp" %>