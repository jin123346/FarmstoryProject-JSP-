<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="./_header.jsp" %>

                
                <div class="section">
                    <section>
                        <div class="main_container">
                            <div class="main_top"><span>관리자 메인</span></div>
                            <div class="status_table">
                                <div class="tbname">
                                    <span>상품현황</span>
                                    <span><a href="/FarmStory/admin/product/list.do">더보기</a></span>
                                </div>
                                <table class="product">
                                    <thead>
                                        <tr>
                                            <th>상품번호</th>
                                            <th>상품명</th>
                                            <th>구분</th>
                                            <th>가격</th>
                                            <th>재고</th>
                                            <th>등록일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:if test="${products ==null }">
                                    	<tr>
                                    		<td>등록된 상품이 없습니다.</td>
                                    	</tr>
                                    	</c:if>
                                    	<c:forEach var="product" items="${products }">
                                    		<tr>
	                                            <td>${product.pNo }</td>
	                                            <td>${product.pName }</td>
	                                            <td>${product.prodCateNo }</td>
	                                            <td>${product.price }</td>
	                                            <td>${product.stock }</td>
	                                            <td>${product.rdate }</td>
                                        	</tr>
                                    	</c:forEach>
  
                                    </tbody>
                                  
                                </table>
                            </div>
                            <div class="status_table">
                                <div class="tbname">
                                    <span>주문현황</span>
                                    <span><a href="/FarmStory/admin/order/list.do">더보기</a></span>
                                </div>
                                <table class="order">
                                   
                                    <thead>
                                        <tr>
                                            <th>주문번호</th>
                                            <th>상품명</th>
                                            <th>판매가격</th>
                                            <th>수량</th>
                                            <th>배송비</th>
                                            <th>합계</th>
                                            <th>주문자</th>
                                            <th>주문일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   	  <c:if test="${orderitems == null }">
                                    	<tr>
                                    		<td>등록된 상품이 없습니다.</td>
                                    	</tr>
                                   	  </c:if>
                                      <c:forEach var="orderitem" items="${orderitems }">
                                        <tr>
                                            <td>${orderitem.OrderNo }</td>
                                            <td>${orderitem.pName }</td>
                                            <td>${orderitem.itemPrice }</td>
                                            <td>${orderitem.itemQty }</td>
                                            <td>${orderitem.o_delivery }</td>
                                            <td>${orderitem.OrderItemTotal }</td>
                                            <td>${orderitem.name }</td>
                                            <td>${orderitem.rdate }</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="status_table">
                                <div class="tbname">
                                    <span>회원현황</span>
                                    <span><a href="/FarmStory/admin/user/list.do">더보기</a></span>
                                </div>
                                <table class="customer">
                                    <thead>
                                        <tr>
                                            <th>회원아이디</th>
                                            <th>이름</th>
                                            <th>닉네임</th>
                                            <th>휴대폰</th>
                                            <th>이메일</th>
                                            <th>등급 </th>
                                            <th>회원가입일</th>
                                         </tr>
                                    </thead>
                                    <tbody>
                                     <c:if test="${userDto == null }">
                                    	<tr>
                                    		<td>등록된 회원이 없습니다.</td>
                                    	</tr>
                                   	  </c:if>
                                     <c:forEach var="userDto" items="${userDto}">
                                        <tr>
                                           <td>${userDto.uid}</td>
				                            <td>${userDto.name}</td>
				                            <td>${userDto.nick}</td>
				                            <td>${userDto.email}</td>
				                            <td>${userDto.hp}</td>
				                            <td>${userDto.gradeNo }</td>
				                            <td>${userDto.regDate}</td>
                                        </tr>
                                      </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div><!--main-container-->
                    </section><!-- section end-->
                </div><!-- .section end-->
               
            </div><!--mainIn-->
        </main><!--main end-->

        <footer>
            <div class="fIn">
                <div class="fttxt">
                    <span>FARMSTORY ADMINISTRATOR Version 1.0.1</span>
                </div>
                <div class="copy">
                    <p>
                        <span>Copyright</span> 김철학(개발에반하다.) All rights reserved.
                    </p>
                    
                </div>
            </div>
        </footer><!--footer-->

    </div> <!--wrapper end-->
</body>
</html>