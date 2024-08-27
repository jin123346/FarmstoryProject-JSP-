<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
        <main>
            <div class="mainIn">
                <section class="terms">
                    <table>
                        <caption>사이트 이용약관</caption>
                        <tr>
                            <td>
                                <textarea readonly>${termsDto.terms}</textarea>
                                <p>
                                    <label><input type="checkbox" name="chk1"/>동의합니다.</label>
                                </p>
                            </td>
                        </tr>
                    </table>
                    <table>
                        <caption>개인정보 취급방침</caption>
                        <tr>
                            <td>
                                <textarea readonly>${termsDto.privacy}</textarea>
                                <p>
                                    <label><input type="checkbox" name="chk2"/>동의합니다.</label>
                                </p>
                            </td>
                        </tr>
                    </table>
                    <div>
                        <a href="/FarmStoryTeam2/member/login.do" class="btnCancel">취소</a>
                        <a href="/FarmStoryTeam2/member/register.do" class="btnNext">다음</a>
                    </div>
                </section>
            </div>
        </main><!-- main end -->
<%@ include file="./_footer.jsp" %>
    
</body>
</html>
