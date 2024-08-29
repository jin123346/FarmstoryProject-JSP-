<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="./_header.jsp" %>
<title>비밀번호 변경</title>
<link rel="stylesheet" href="../css/user/passwordchange.css">
<script>

</script>
        <!-- 메인 -->
         <main>
            <section>
                <form action="">
                    <h1>비밀번호 변경</h1>
                    <table class="passwordchange">
                        <tbody>
                            <tr>
                                <th>
                                    <label>아이디</label>
                                </th>
                                <td>
                                      honggildong
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <label>새 비밀번호</label>
                                </th>
                                <td>
                                    <input type="text" placeholder="새 비밀번호 입력">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <label>새 비밀번호 확인</label>
                                </th>
                                <td>
                                    <input type="text" placeholder="새 비밀번호 입력">
                                    
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <p>
                        비밀번호를 변경해 주세요.<br>
                        영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.
                    </p>
                    <div>
                        <button type="button" class="cancel-button">
                            <span>취소</span>
                        </button>
                        <button type="button" class="next-button">
                            <span>다음</span>
                        </button>
                    </div>
                </form>
            </section>
        </main>

	<%@ include file="./_footer.jsp" %>

