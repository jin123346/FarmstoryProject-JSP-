<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="../_header.jsp" %>
                
<div class="section list">
    <section>
        <div class="main_container">
            <div class="main_top"><span>주문목록</span></div>
            <div class="status_table" id="orderList">
                <table class="Order">
                    <thead>
                        <tr>
                            <th><input type="checkbox" name="product_list_checkbox" id="plcheck"></th>
                            <th>주문번호</th>
                            <th>상품명</th>
                            <th>판매가격</th>
                            <th>수량</th>
                            <th>배송비</th>
                            <th>합계</th>
                            <th>주문자</th>
                            <th>주문일 </th>
                            <th>확인 </th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="orderItem" items="${orderItems }">
                        <tr>
                            <td><input type="checkbox" name="order_list_checkbox" id="olcheck"></td>
                            <td>${orderItem.oderNo }</td>
                            <td>${orderItem.pName }</td>
                            <td>${orderItem.itemPrice }원</td>
                            <td>${orderItem.itemQty}</td>
                            <td>${orderItem.getO_delivery() }</td>
                            <td>${orderItem.total }</td>
                            <td>${orderItem.name }</td>
                            <td>${orderItem.orderDate }</td>
                            <td><a href="/FarmStory/market/view.do?pNo=${orderItem.pNo }">[상세확인]</a></td>
                        </tr>
                       </c:forEach>
                    </tbody>
                </table><!--Order-->
                <div class="btn_group">
                        <a href="#"  class="deletebtn">선택삭제</a>
                </div><!--btn_group end-->

                <div class="pages">
                	<ul>
                	<c:if test="${pageGroup.start > 1}">
                    	<li><a href="/FarmStory/admin/order/list.do?pg=${pageGroup.start-1}" class="prev">이전</a></li>
                    </c:if>
                    <c:forEach var="i" begin="${pageGroup.start}" end="${pageGroup.end}">
                    	<li><a href="/FarmStory/admin/order/list.do?pg=${i}" class="num ${currentPage == i ? 'current':'off'}">${i}</a></li>
                    </c:forEach>
                    <c:if test="${pageGroup.end < lastPageNum}">
                    	<li><a href="/FarmStory/admin/order/list.do?pg=${pageGroup.end+1}" class="next">다음</a></li>
                    </c:if>
                    </ul>
                </div><!--pages-->
               
            </div><!--status-table end-->
           
        </div><!--main-container-->
    </section><!-- section end-->
</div><!-- .section end-->
       
    </div><!--mainIn-->
</main><!--main end-->

<%@ include file="../_footer.jsp" %>