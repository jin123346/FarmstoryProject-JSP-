<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="section list">
    <section>
        <div class="main_container">
            <div class="main_top"><span>회원목록</span></div>
            <div class="status_table" id="userList">
                <table class="user">
                    <thead>
                        <tr>
                            <th><input type="checkbox" name="user_list_checkbox" id="plcheck"></th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>별명</th>
                            <th>이메일</th>
                            <th>휴대폰</th>
                            <th>등급</th>
                            <th>가입일 </th>
                            <th>확인 </th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="userDto" items="${userDto}">
                        <tr>
                            <td><input type="checkbox" name="uid_list_checkbox" id="plcheck"></td>
                            <td>${userDto.uid}</td>
                            <td>${userDto.name}</td>
                            <td>${userDto.nick}</td>
                            <td>${userDto.email}</td>
                            <td>${userDto.hp}</td>
                            <td>
                            <select name="grade" id="grade">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            
                            ${userDto.gradeNo}</td>
                            <td>${userDto.regDate}</td>
                            <td><a href="#">[상세확인]</a></td>
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
                <div class="btn_group">
                 <a href="/FarmStory/admin/user/list.do"  class="deletebtn">선택삭제</a>
                 
                       <!-- 페이지 네비게이션 -->
              <div class="pages">
              
                <c:if test="${pageGroup.start > 1}">
                  <li>  <a href="FarmStory/admin/user/list.do?pg=${pageGroup.start-1}" class="prev">이전</a></li>
                  </c:if>
                    <c:forEach var="i" begin="${pageGroup.start}" end="${lastPageNum}">
                    	<li><a href="/FarmStory/admin/user/list.do?pg=${i}" class="num ${currentPage == i ? 'current' : 'off'}">${i}</a></li>
                    </c:forEach>
                    <c:if test="${pageGroup.end < lastPageNum}">
                   <li><a href="/FarmStory/admin/user/list.do?pg=${pageGroup.end+1}" class="next">다음</a></li>
                </c:if>
                </div>
                </div><!--btn_group end-->
            </div><!--status-table end-->
        </div><!--main-container-->
    </section><!-- section end-->
</div><!-- .section end-->

</div><!--mainIn-->
</main><!--main end-->
<%@ include file="../_footer.jsp" %>