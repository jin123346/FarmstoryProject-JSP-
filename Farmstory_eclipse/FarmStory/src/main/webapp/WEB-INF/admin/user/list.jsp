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
						        <option value="11" ${userDto.gradeNo == 11 ? 'selected="selected"' : ''}>1</option>
						        <option value="22" ${userDto.gradeNo == 22 ? 'selected="selected"' : ''}>2</option>
						        <option value="33" ${userDto.gradeNo == 33 ? 'selected="selected"' : ''}>3</option>
						        <option value="44" ${userDto.gradeNo == 44 ? 'selected="selected"' : ''}>4</option>
						        <option value="55" ${userDto.gradeNo == 55 ? 'selected="selected"' : ''}>5</option>
						        <option value="00" ${userDto.gradeNo == 00 ? 'selected="selected"' : ''}>0</option>
						    </select>
                            <td>${userDto.regDate}</td>
                            <td><a href="#">[상세확인]</a></td>
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
                <div class="btn_group">
                        <a href="/FarmStory/admin/user/list.do"  class="deletebtn">선택삭제</a>
                </div><!--btn_group end-->

                <div class="pages">
                    <ul>
                     <li><a href="#">&nbsp;[1]</a></li>
                     <li><a href="#">[2]</a></li>
                     <li><a href="#">[3]</a></li>
                     <li><a href="#">[4]</a></li>
                     <li><a href="#">[5]&nbsp;</a></li>
                    </ul>
                </div><!-- pages -->
            </div><!--status-table end-->
        </div><!--main-container-->
    </section><!-- section end-->
</div><!-- .section end-->
  
</div><!--mainIn-->
</main><!--main end-->
<%@ include file="../_footer.jsp" %>