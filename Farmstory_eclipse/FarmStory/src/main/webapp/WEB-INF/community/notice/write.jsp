<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<title>글쓰기</title>
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
                <section class="write">
                	<h3>글쓰기</h3>
                	<article>
                    <form action="/FarmStory/community/notice/write.do" method="post" enctype="multipart/form-data">
                    	<input type="hidden" name="b_writer" value="${sessUser.uid}">
                        <table>
                            <tr>
                                <td>제목</td>
                                <input type="hidden" name="b_cateNo" value="${cate}"/>
                                <input type="hidden" name="group" value="${group}"/>
                                <td><input type="text" name="title" placeholder="제목을 입력하세요."/></td>
                            </tr>
                            <tr>
                                <td>내용</td>
                                <td>
                                    <textarea name="b_contents"></textarea>                                
                                </td>
                            </tr>
                            <tr>
                                <td>첨부</td>
                                <td>
                               		<p style="margin-bottom: 6px; ">
                                		최대 2개 파일 첨부 가능, 각 파일당 최대 10MB 까지 업로드
                                	</p>
                                	<input type="file" name="file1"/>
                                	<input type="file" name="file2"/>
                                </td>
                            </tr>
                        </table>
                        <div>
                            <a href="/FarmStory/community/notice/list.do?group=${group}&cate=${cate}" class="btnCancel">취소</a>
                            <input type="submit"  class="btnWrite" value="작성완료">
                        </div>
                    </form>
                </article>
            </section>
                    </div><!-- .articleIn -->
                </article><!-- .article -->
            </section>
        </main><!-- #main -->
<%@ include file="../../_footer.jsp" %>