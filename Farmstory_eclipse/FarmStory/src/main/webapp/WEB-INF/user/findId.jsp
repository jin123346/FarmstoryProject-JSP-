<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<title>아이디찾기</title>
<link rel="stylesheet" href="../css/user/findid.css">
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
        const name = document.getElementById('name').value;

        if (!email || !name) {
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



        <main id="main" class="cf">
            <div class="mainIn">
            <div class="container">
		            <form action="/FarmStory/member/findIdResult.do" method="post" enctype="multipart/form-data">
		                <section>
		                    <div class="headtxt">
		                        <span>아이디 찾기</span>
		                    </div>
		                    
		                        <table>
		                            <tr>
		                                <td>이름</td>
		                                <td>
		                                    <input type="text" id="name" name="name"  placeholder="이름 입력">
		                                </td>
		                            </tr>
		                            <tr>
		                                <td>이메일</td>
		                                <td>
		                                    <div class="form_group">
		                                        <input type="email" name="email" id="email" placeholder="이메일 입력">
		                                        <button type="button" class="btnSendEmail" id="btnSendEmail">인증번호 받기</button>
		                                  		<span class=resultEmail></span>
		                                    </div>
		                                    <div class="form_group">
		                                        <input type="text" id="code" name="auth" placeholder="인증번호 입력">
		                                        <button type="button" class="btnAuthEmail" id="btnAuthEmail">확인</button>
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

