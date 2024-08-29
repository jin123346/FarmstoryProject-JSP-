<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<title>글목록</title>
<link rel="stylesheet" href="../css/event.css">
<%@ include file="../_aside_et.jsp" %>
  						<div id="container">
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
                                        <c:forEach var="board" items="${boards}">
                                        <tr>
                                            <td>${board.no}</td>
                                            <td><a href="/FarmStroy/event/view.do?no=${board.no}">${board.title}</a>&nbsp;[${board.comment}]</td>
                                            <td>${board.nick}</td>
                                            <td>>${board.rdate}</td>
                                            <td>${board.hit}</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                </article>
                
                                <!-- 페이지 네비게이션 -->
                                <div class="paging">
                                    <a href="#" class="prev">이전</a>
                                    <a href="#" class="num current">1</a>                
                                    <a href="#" class="num">2</a>                
                                    <a href="#" class="num">3</a>                
                                    <a href="#" class="next">다음</a>
                                </div>
                
                                <!-- 글쓰기 버튼 -->
                               <a href="/FarmStroy/event/write.do" class="btnWrite">글쓰기</a>
                            </section>
                         </div>
                    </div><!-- .articleIn -->
                </article><!-- .article -->
            </section>
        </main><!-- #main -->
     
     <%@ include file="./_footer.jsp" %>
