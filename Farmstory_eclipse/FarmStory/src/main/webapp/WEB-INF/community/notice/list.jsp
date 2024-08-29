<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<title>글목록</title>
<link rel="stylesheet" href="../../css/community.css">
<c:choose>
	<c:when test="${group eq 'croptalk'}">
		<%@ include file="../../_aside_ct.jsp" %>
		<link rel="stylesheet" href="../../css/croptalk.css">
	</c:when>
	<c:when test="${group eq 'event'}">
		<%@ include file="../../_aside_et.jsp" %>
		<link rel="stylesheet" href="../../css/event.css">
	</c:when>
	<c:otherwise><%@ include file="../../_aside_cm.jsp" %></c:otherwise>
</c:choose> 
                        <section class="list">
                            <h3>글목록</h3>
                            <article>
                                <table border="0">
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>글쓴이</th>
                                        <th>날짜</th>
                                        <th>조회</th>
                                    </tr>
                                    <c:if test="${empty boards}">
						                <tr>
						                    <td colspan="5" class="td_first">등록된 게시물이 없습니다.</td>
						                </tr>
						            </c:if>
                                    <c:forEach var="board" items="${boards}">
	                                    <tr>
	                                        <td>${pageStartNum}</td>
	                                        <td><a href="/FarmStory/community/notice/view.do?boardNo=${board.boardNo}&pg=${currentPage}&group=${group}&cate=${cate}">${board.title}</a>&nbsp;[${board.commentCount}]</td>
	                                        <td>${board.nick}</td>
	                                        <td>${board.b_rdate}</td>
	                                        <td>${board.b_hit}</td>
	                                    </tr>
	                                    <!-- 한번 반복할때마다 pageStartNum을 1씩 차감 -->
				                        <c:set var="pageStartNum" value="${pageStartNum-1}"/>
			                        </c:forEach>
                                </table>
                            </article>
            
                            <!-- 페이지 네비게이션 -->
			                <div class="paging">
							    <c:if test="${pageGroup.start > 1}">
							        <a href="/FarmStory/community/notice/list.do?pg=${pageGroup.start-1}&pg=${currentPage}&group=${group}&cate=${cate}" class="prev">이전</a>
							    </c:if>
							    <c:forEach var="i" begin="${pageGroup.start}" end="${pageGroup.end}">
							        <c:choose>
							            <c:when test="${i == currentPage}">
							                <a href="/FarmStory/community/notice/list.do?pg=${i}&pg=${currentPage}&group=${group}&cate=${cate}" class="num current">${i}</a>
							            </c:when>
							            <c:otherwise>
							                <a href="/FarmStory/community/notice/list.do?pg=${i}&pg=${currentPage}&group=${group}&cate=${cate}" class="num">${i}</a>
							            </c:otherwise>
							        </c:choose>
							    </c:forEach>
							    <c:if test="${pageGroup.end < lastPageNum}">
							        <a href="/FarmStory/community/notice/list.do?pg=${pageGroup.end+1}&pg=${currentPage}&group=${group}&cate=${cate}" class="next">다음</a>
							    </c:if>
							</div>
                            <!-- 글쓰기 버튼 -->
                            <a href="/FarmStory/community/notice/write.do?group=${group}&cate=${cate}" class="btnWrite">글쓰기</a>
                        </section>
                    </div><!-- .articleIn -->
                </article><!-- .article -->
            </section>
        </main><!-- #main -->
<%@ include file="../../_footer.jsp" %>