<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<title>아이디 찾기</title>
 <link rel="stylesheet" href="../css/user/findid.css">

        <main>
            <div class="mainIn">
            <div class="container">
		            <form>
		                <section>
		                    <div class="headtxt">
		                        <span>아이디 찾기</span>
		                    </div>
		                        <table>
		                            <tr>
		                                <td>이름</td>
		                                <td>
		                                    <input type="text" id="name" placeholder="이름 입력">
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>이메일</td>
		                                <td>
		                                    <div class="form_group">
		                                        <input type="email" id="email" placeholder="이메일 입력">
		                                        <button type="button" class="btn_auth">인증번호 받기</button>
		                                    </div>
		                                    <div class="form_group">
		                                        <input type="text" id="code" placeholder="인증번호 입력">
		                                        <button type="button" class="btn_confim">확인</button>
		                                    </div>
		                                </td>
		                            </tr>
		                        </table>
		               	 </section>
		                <div class="findnote">
		                    <p>
		                    회원가입시 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
		                    인증번호를 입력 후 확인 버튼을 누르세요. 
		                    </p>
		                </div>
		                <div class="btns">
		                    <button type="button" class="btn_cancel">취소</button>
		                    <button type="submit" class="btn_next">다음</button>
		                </div>
		            </form>
       		 </div>
                
                
            </div>
        </main>

	<%@ include file="./_footer.jsp" %>

