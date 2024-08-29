<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<title>비밀번호 찾기</title>
 <link rel="stylesheet" href="../css/user/style_password.css">
        <main>
            <div class="mainIn">
	              <section>
	                <form action="" method="post">
	                    <h1 class="tit">비밀번호 찾기</h1>
	                    <table class="password">
	                        <tbody>
	                            <tr>
	                                <th>
	                                    <label>아이디</label>
	                                </th>
	                                <td>
	                                    <input type="text" placeholder="아이디 입력">
	                                    
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>
	                                    <label>이메일</label>
	                                </th>
	                                <td>
	                                    <div>
	                                        <input type="text" placeholder="이메일 입력">
	                                        <button type="button" class="auth-button">
	                                            <span>인증번호 받기</span>
	                                        </button>
	                                    </div>
	                                    <div>
	                                        <input type="text" placeholder="인증번호 입력">
	                                        <button type="button" class="ok-button">
	                                            <span>확인</span>
	                                        </button>
	                                    </div>
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                    <p class="info">
	                        비밀번호를 찾고자 하는 아이디와 이메일을 입력해 주세요. <br>
	                        회원가입시 입력한 아이디와 이메일 주소가 같아야, 인증번호를 받을 수 있습니다. <br>
	                        인증번호를 입력 후 확인 버튼을 누르세요.
	                    </p>
	                    <div class="btn cf">
	                        <a href="#" class="cancel-button">취소</a>
	                        <a href="#" class="next-button">다음</a>
	                    </div>
	                </form>
	            </section><!-- section end -->
            </div><!-- .mainIn end -->
        </main><!-- main end -->

	<%@ include file="./_footer.jsp" %>

