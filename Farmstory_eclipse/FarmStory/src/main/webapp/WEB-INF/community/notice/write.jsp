<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<title>글쓰기</title>
<link rel="stylesheet" href="../../css/community.css">
<%@ include file="../../_aside_cm.jsp" %>
                <section class="write">
                	<h3>글쓰기</h3>
                	<article>
                    <form action="/FarmStory/community/notice/write.do" method="post" enctype="multipart/form-data">
                    	<input type="hidden" name="b_writer" value="${sessUser.uid}">
                        <table>
                            <tr>
                                <td>제목</td>
                                <input type="hidden" name="b_cateNo" value="${b_cateNo}"/>
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
                            <a href="/FarmStory/community/notice/list.do" class="btnCancel">취소</a>
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