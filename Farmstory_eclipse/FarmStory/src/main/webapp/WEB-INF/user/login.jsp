<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
    <title>Login</title>

<script>
	const success=${success};
	
	if(success==100){
		alert('로그인에 실패했습니다.\n다시 시도해주세요');
	}else if(success==101){
		alert('성공적으로 로그아웃 되었습니다.');
		
	}
</script>
 
        <main>
            <div class="mainIn">
                <section class="login">
                    <form action="/FarmStory/member/login.do" method="post">
                        <table border="0">
                            <tr>
                                <td><img src="../images/login_ico_id.png" alt="아이디"></td>
                                <td><input type="text" name="uid" placeholder="아이디 입력"></td>
                            </tr>
                            <tr>
                                <td><img src="../images/login_ico_pw.png" alt="비밀번호"></td>
                                <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
                            </tr>
                        </table>
                        <input type="submit" value="로그인" class="btnLogin">
                    </form>
                    <div>
                        <h3>회원 로그인 안내</h3>
                        <p>
                            아직 회원이 아니시면 회원으로 가입하세요.
                        </p>

                        <a href="/FarmStory/member/terms.do" class="join_mem">&nbsp회원가입</a>
                        <a href="/FarmStory/member/findPass.do">&nbsp비밀번호찾기</a>
                        <a href="/FarmStory/member/findId.do">아이디찾기</a>

                    </div>
                </section>
            </div>
        </main>

	<%@ include file="./_footer.jsp" %>

