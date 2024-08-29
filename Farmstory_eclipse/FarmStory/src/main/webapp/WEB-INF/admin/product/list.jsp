<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="../../_header.jsp" %>

<div class="section list">
    <section>
        <div class="main_container">
            <div class="main_top"><span>상품목록</span></div>
            <div class="status_table" id="productList">
                <table class="product">
                    <thead>
                        <tr>
                        	<th><input type="checkbox" name="product_list_checkbox" class="check"></th>
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
                   	<c:forEach var="product" items="${products}">
                        <tr>
                            <td><input type="checkbox" name="product_list_checkbox" id="plcheck"></td>
                            <c:choose>
					            <c:when test="${product.sName == null}">
					                <td><img src="/FarmStory/images/no_image.jpg" alt="no image" width="60" height="60" /></td>
					            </c:when>
					            <c:otherwise>
					                <td><img src="/FarmStory/thumbs/product/${product.sName }" alt="${product.pName}" width="60" height="60" /></td>
					            </c:otherwise>
					        </c:choose>
                            <!-- <td><img src="../images/sample_item1.jpg" id="product_img1" alt="샘플 이미지"></td> -->
                            <td>${product.pNo}</td>
                            <td>${product.pName}</td>
                            <td>${product.prodCateNo}</td>
                            <td>${product.price}</td>
                            <td>${product.stock}</td>
                            <td>${product.rdate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="btn_group">
                        <a href="#"  class="deletebtn">선택삭제</a>
                        <a href="/FarmStory/product/register.do"  class="insertbtn">상품등록</a>
                </div><!--btn_group end-->
                
                
                <div class="pages">
                	<ul>
                	<c:if test="${pageGroup.start > 1}">
                    	<li><a href="/FarmStory/admin/product/list.do?pg=${pageGroup.start-1}" class="prev">이전</a></li>
                    </c:if>
                    <c:forEach var="i" begin="${pageGroup.start}" end="${pageGroup.end}">
                    	<li><a href="/FarmStory/admin/product/list.do?pg=${i}" class="num ${currentPage == i ? 'current':'off'}">${i}</a></li>
                    </c:forEach>
                    <c:if test="${pageGroup.end < lastPageNum}">
                    	<li><a href="/FarmStory/admin/product/list.do?pg=${pageGroup.end+1}" class="next">다음</a></li>
                    </c:if>
                    </ul>
                </div>
               
            </div><!--status-table end-->

           
        </div><!--main-container-->
    </section><!-- section end-->
</div><!-- .section end-->
   
</div><!--mainIn-->
</main><!--main end-->
<%@ include file="../_footer.jsp" %>