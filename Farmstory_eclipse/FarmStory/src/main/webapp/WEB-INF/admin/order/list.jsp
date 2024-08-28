<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <tr>
                            <td><input type="checkbox" name="product_list_checkbox" id="plcheck"></td>
                            <td>1001</td>
                            <td>사과500g</td>
                            <td>4,000원</td>
                            <td>2</td>
                            <td>3,000원</td>
                            <td>11,000원</td>
                            <td>김유신</td>
                            <td>2023-01-01 13:06:14</td>
                            <td><a href="#">[상세확인]</a></td>
                        </tr>
                    </tbody>
                </table><!--Order-->
                <div class="btn_group">
                        <a href="#"  class="deletebtn">선택삭제</a>
                </div><!--btn_group end-->

                <div class="pages">
                    <ul>
                     <li><a href="#">&nbsp;[1]</a></li>
                     <li><a href="#">[2]</a></li>
                     <li><a href="#">[3]</a></li>
                     <li><a href="#">[4]</a></li>
                     <li><a href="#">[5]&nbsp;</a></li>
                    </ul>
                </div><!--pages-->
               
            </div><!--status-table end-->
           
        </div><!--main-container-->
    </section><!-- section end-->
</div><!-- .section end-->
       
    </div><!--mainIn-->
</main><!--main end-->

<%@ include file="../_footer.jsp" %>