<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="./_header.jsp" %>
<title>비밀번호변경</title>
<link rel="stylesheet" href="../css/user/findidresult.css">
<script>
let isPassOk = false;



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
        <main>
            <div class="mainIn">
          <div class="container">
            <form action="/FarmStory/member/findIdResult.do" method="post" enctype="multipart/form-data">
            <section>
                <div class="top_txt">
                    <span>비밀번호 변경</span>
                </div>
	                <table>
	                    <tr>
	                        <td>아이디</td>
	                        <td>
	                            <p><span>${uid }</span></p>
	                            <input type="hidden" value="${uid }" name="uid">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>새비밀번호</td>
	                        <td>
	                            <input type="password" name="pass1" placeholder="비밀번호 입력"/>  
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>새비밀번호 변경</td>
	                        <td>
	                            <input type="password" name="pass2" placeholder="비밀번호 확인 입력"/>
	                             <span class="resultPass"></span>
	                        </td>
	                    </tr>
	                </table>
                
            </section>
              <div class="findnote">
	                   <p>
	                   비밀번호를 변경해 주세요.
					영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.
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

