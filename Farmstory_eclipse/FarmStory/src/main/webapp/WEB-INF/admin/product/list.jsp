<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>

<div class="section list">
    <section>
        <div class="main_container">
            <div class="main_top"><span>상품목록</span></div>
            <div class="status_table" id="productList">
                <table class="product">
                    <thead>
                        <tr>
                            <th>사진</th>
                            <th>상품번호</th>
                            <th>상품명</th>
                            <th>구분</th>
                            <th>가격</th>
                            <th>재고</th>
                            <th>등록일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><img src="../images/sample_item1.jpg" id="product_img1" alt="샘플 이미지"></td>
                            <td>1011</td>
                            <td>사과500g</td>
                            <td>과일</td>
                            <td>4,000원</td>
                            <td>100</td>
                            <td>2023-01-01</td>
                        </tr>
                    </tbody>
                </table>
                <div class="btn_group">
                        <a href="#"  class="deletebtn">선택삭제</a>
                        <a href="#"  class="insertbtn">상품등록</a>
                </div><!--btn_group end-->

                <div class="pages">
                    <ul>
                     <li><a href="#">&nbsp;[1]</a></li>
                     <li><a href="#">[2]</a></li>
                     <li><a href="#">[3]</a></li>
                     <li><a href="#">[4]</a></li>
                     <li><a href="#">[5]&nbsp;</a></li>
                    </ul>
                </div>
               
            </div><!--status-table end-->

           
        </div><!--main-container-->
    </section><!-- section end-->
</div><!-- .section end-->
   
</div><!--mainIn-->
</main><!--main end-->
<%@ include file="../_footer.jsp" %>