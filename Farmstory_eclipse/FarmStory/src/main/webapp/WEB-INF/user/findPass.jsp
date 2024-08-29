<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="./_header.jsp" %>
<title>비밀번호 찾기</title>
 <link rel="stylesheet" href="../css/user/style_password.css">
 <script>
		let isEmailOk = false;
		window.onload = function() {
		    const btnSendEmail = document.getElementById('btnSendEmail');
		    const btnAuthEmail = document.getElementById('btnAuthEmail');
		    const resultEmail = document.querySelector('.resultEmail');
		    const registerForm = document.getElementsByTagName('form')[0];
		    const auth = document.getElementsByClassName('auth')[0];
		  
		    let preventDblClick = false;
		
		    btnSendEmail.onclick = async function() {
		        if (preventDblClick) return;
		
		        const email = document.getElementById('email').value;
		        const uid = document.getElementById('uid').value;
		
		        if (!email || !uid) {
		            resultEmail.innerText = "이름과 이메일을 모두 입력하세요.";
		            resultEmail.style.color = "red";
		            return;
		        }
		
		        try {
						preventDblClick = true;
						
						const response = await fetch('/FarmStory/member/checkid.do?type=email&value='+email);
						const data = await response.json();
						console.log(data);	
						 if (data.result > 0) {
				                resultEmail.innerText = "인증번호가 발송되었습니다.";
				                resultEmail.style.color = "green";
				            } else {
				                resultEmail.innerText = "다시 시도해주세요.";
				                resultEmail.style.color = "red";
				            }
		        } catch (error) {
		            console.error('Error:', error);
		            resultEmail.innerText = "오류가 발생했습니다.";
		            resultEmail.style.color = "red";
		        } finally {
		            preventDblClick = false;
		        }
		    };
		
		    btnAuthEmail.onclick = function(){
		
				const code = registerForm.auth.value;
				
				fetch('/FarmStory/member/checkid.do', {
					method: 'POST',
					body: JSON.stringify({"code":code})
					})
					.then(resp=>resp.json())
					.then(data=>{
						console.log(data);
						
						if(data.result > 0){
							resultEmail.innerText = '이메일이 인증되었습니다.';
							resultEmail.style.color = 'green';
							isEmailOk = true;
							
						} else {
							resultEmail.innerText = '유효한 인증코드가 아닙니다.';
							resultEmail.style.color = 'red';
							isEmailOk = false;
						}
						
					})
					.catch(err=>{
						console.log(err);
					});
				
			}
		    
		    
		 // 최종 폼 전송 유효성 검사
			registerForm.onsubmit = function(){
				// 이메일 유효성 검사 완료 여부
				if(!isEmailOk){
					alert('이메일이 유효하지 않습니다.');
					return false;
				}
				
				
				return true;
			}
		}
 </script>
 
        <main>
            <div class="mainIn">
	              <section>
	                <form action="/FarmStory/member/findPass.do" method="post" enctype="multipart/form-data">
	                    <h1 class="tit">비밀번호 찾기</h1>
	                    <table class="password">
	                        <tbody>
	                            <tr>
	                                <th class="input_id" style="border-right: 1px solid #E9E9E9;">
	                                    <label>아이디</label>
	                                </th>
	                                <td>
	                                    <input type="text" id="uid" name="uid" placeholder="아이디 입력">
	                                  
	                                </td>
	                            </tr>
	                            <tr>
	                                <th>
	                                    <label>이메일</label>
	                                </th>
	                                <td>
	                                    <div>
	                                        <input type="email" name="email" id="email" placeholder="이메일 입력">
	                                        <button type="button" class="auth-button" id="btnSendEmail">
	                                            <span>인증번호 받기</span>
	                                        </button>
	                                        <span class=resultEmail></span>
	                                    </div>
	                                    <div>
	                                        <input type="text" name="auth" placeholder="인증번호 입력">
	                                        <button type="button" class="ok-button" id="btnAuthEmail">
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
	                        <button type="submit" class="next-button">다음</button>
	                    </div>
	                </form>
	            </section><!-- section end -->
            </div><!-- .mainIn end -->
        </main><!-- main end -->

	<%@ include file="./_footer.jsp" %>

