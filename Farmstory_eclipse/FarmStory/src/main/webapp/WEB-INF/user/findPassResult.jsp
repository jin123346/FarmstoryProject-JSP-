<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="./_header.jsp" %>
<title>비밀번호 변경</title>
<link rel="stylesheet" href="../css/user/style_passwordchange.css">
<script>
		let isPassOk = false;
		const rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;

		window.onload = function(){
			
			const registerForm = document.getElementsByTagName('form')[0];
			const resultPass = document.getElementsByClassName('resultPass')[0];
			const auth = document.getElementsByClassName('auth')[0];
			
			
			// 2. 비밀번호 유효성 검사
			registerForm.pass2.addEventListener('focusout', function(){
		
				const pass1 = registerForm.pass1.value;
				const pass2 = registerForm.pass2.value;
				
				if(!pass1.match(rePass)){
					resultPass.innerText = "비밀번호가 유효하지 않습니다.";
					resultPass.style.color='red';
					return;
				}
				
				if(pass1 == pass2){
					resultPass.innerText = '비밀번호가 일치합니다';
					resultPass.style.color='green';
					isPassOk = true;
				}else{
					resultPass.innerText = '비밀번호가 일치하지 않습니다.'
					resultPass.style.color='red';
					isPassOk = false;	
				}
				
			}); // end pass
			
			// 최종 폼 전송 유효성 검사
			registerForm.onsubmit = function(){
		
				// 비밀번호 유효성 검사 완료 여부
				if(!isPassOk){
					alert('비밀번호가 유효하지 않습니다.');
					return false;
				}
				
				return true;
			}
		}
</script>
        <!-- 메인 -->
         <main>
            <section>
                <form action="/FarmStory/member/findPassResult.do" method="post" enctype="multipart/form-data">
                    <h1>비밀번호 변경</h1>
                    <table class="passwordchange">
                        <tbody>
                            <tr>
                                <th>
                                    <label>아이디</label>
                                </th>
                                <td>
                                      <span>${uid }</span>
                                      <input type="hidden" value="${uid }" name="uid">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <label>새 비밀번호</label>
                                </th>
                                <td>
                                    <input type="password" name="pass1" placeholder="비밀번호 입력"/> 
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <label>새 비밀번호 확인</label>
                                </th>
                                <td>
                                    <input type="password" name="pass2" placeholder="비밀번호 확인 입력"/>
	                             	<span class="resultPass"></span>
                                    
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <p>
                        비밀번호를 변경해 주세요.<br>
                        영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.
                    </p>
                    <div>
                        <a href="/FarmStory/member/login.do" class="cancel-button">취소</a>
                        <button type="submit" class="next-button">
                            <span>다음</span>
                        </button>
                    </div>
                </form>
            </section>
        </main>

	<%@ include file="./_footer.jsp" %>