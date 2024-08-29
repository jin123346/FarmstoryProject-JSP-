<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="./_header.jsp" %>
    <title>MyInfo</title>
  <link rel="stylesheet" href="../css/user/myinfo.css">
  <script>
  window.onload = function() {
	    // 비밀번호 입력 필드와 버튼을 가져옴
	    const login= document.getElementById('login');
   	    const register= document.getElementById('register');
	    const inputPassword = document.getElementById('input_password');
	    const inputPasswordConfirm = document.getElementById('input_password_confirm'); // 추가된 비밀번호 확인 필드 ID
	    const btnModify = document.querySelector('.btn_modifty');
	    const resultPass = document.getElementsByClassName('resultPass')[0];
	    const sessUid = "${sessUser.uid}";
	    if(!${sessUser}){
	    	alert("세션이 만료되었습니다.")
	    	window.location.href = "/FarmStory/member/login.do";
	    }else{
	    	login.innerText="로그아웃";
	        login.href="/FarmStory/member/logout.do";
	        register.innerText="마이페이지";
	        register.href="/FarmStory/member/myInfo.do?uid="+sessUid;
	    }
	    
	    
	    async function sha256(message) {
	        const msgBuffer = new TextEncoder().encode(message);
	        const hashBuffer = await crypto.subtle.digest('SHA-256', msgBuffer);
	        const hashArray = Array.from(new Uint8Array(hashBuffer));
	        const hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
	        return hashHex;
	    }
	    
	    
	    // 비밀번호 일치 여부 확인 함수
	    const sessPass = '${sessUser.pass}';
	    async function checkPasswordMatch() {
	        const pass1 = inputPassword.value;
	        const pass2 = inputPasswordConfirm.value;

	        if (pass1 === pass2) {
	            const pass1Hash = await sha256(pass1);
	            if (pass1Hash === sessPass) {
	            	resultPass.innertext = "비밀번호가 일치합니다.";
	            	resultPass.style.color='green';

	                enableEditing();
	                return true;
	            } else {
	            	resultPass.innerText = "비밀번호가 유효하지 않습니다.";
	    			resultPass.style.color='red';
	                disableEditing();
	                return false;
	            }
	        } else {
	        	resultPass.innertext = "비밀번호가 일치하지 않습니다.";
            	resultPass.style.color='red';
	            disableEditing();
	            return false;
	        }
	    }

	    inputPasswordConfirm.addEventListener('input', async function() {
	        await checkPasswordMatch();
	    });

	    
	    
	 // 개인정보 수정 필드들 가져오기
	    const inputName = document.getElementById('input name');
	    const inputNick = document.getElementById('input nickname');
	    const inputEmail = document.getElementById('input email');
	    const inputZip = document.getElementById('search_address');
	    const inputAddr1 = document.getElementById('input_address1');
	    const inputAddr2 = document.getElementById('input_address2');

	    // 서버에서 전달된 UID 값
	   
	   
	   
	 	// 비밀번호 수정 버튼 클릭 시 이벤트 처리
	    btnModify.addEventListener('click', async function() {
		    if (await checkPasswordMatch()) {
		        const uid = '${sessUser.uid}'; // JSP에서 `sessUser.uid`를 가져옵니다
		
		        const form = document.createElement('form');
		        form.method = 'get'; // 또는 'get'
		        form.action = '/FarmStory/member/findPassResult.do';
		
		        // Hidden input을 추가합니다
		        const inputUid = document.createElement('input');
		        inputUid.type = 'hidden';
		        inputUid.name = 'uid';
		        inputUid.value = uid;
		
		        form.appendChild(inputUid);
		
		        // Form을 body에 추가하고 제출합니다
		        document.body.appendChild(form);
		        form.submit();
		    }
		});

	    // 수정 가능하게 만드는 함수
	    function enableEditing() {
	        inputName.removeAttribute('readonly');
	        inputNick.removeAttribute('readonly');
	        inputEmail.removeAttribute('readonly');
	        inputAddr2.removeAttribute('readonly');
	    }

	    // 수정 불가능하게 만드는 함수
	    function disableEditing() {
	        inputName.setAttribute('readonly', true);
	        inputNick.setAttribute('readonly', true);
	        inputEmail.setAttribute('readonly', true);
	        inputAddr2.setAttribute('readonly', true);
	    }

	    
	    // 닉네임 중복 체크 함수
	    function checkNickDuplicate() {
	        const nick = inputNick.value;
	        
	        if (!nick) {
	            alert("별명을 입력해 주세요.");
	            return;
	        }

	        // AJAX 요청으로 서버에 중복 체크 요청
	        fetch("/FarmStory/member/checkUser.do?type=nick&value="+nick)
	            .then(response => response.json())
	            .then(data => {
	                if (data.result >0) {
	                    alert("이미 사용 중인 별명입니다. 다른 별명을 선택해 주세요.");
	                    inputNick.focus();
	                } else {
	                    alert("사용 가능한 별명입니다.");
	                    inputNick.removeAttribute('readonly'); // 중복이 없으면 수정 가능하게
	                }
	            })
	            .catch(error => console.error('Error:', error));
	    }

	    
	    // 중복 체크 버튼 클릭 시 이벤트 처리
	   // btnDuplicateNick.addEventListener('click', checkNickDuplicate);
	    
	 // 회원탈퇴 버튼 클릭 시 이벤트 처리
	    document.querySelector('.btn_quit').addEventListener('click', function() {
	        if (!checkPasswordMatch()) {
	        	alert('비밀번호를 입력해주세요!')	
	        	return false;
	        }
	        const confirmQuit = confirm("정말로 회원탈퇴를 하시겠습니까?");

	        if (confirmQuit) {
	            window.location.href = "/FarmStory/member/delete.do";
	        }
	    });

	 // 개인정보 수정 필드들 가져오기
	    
	    const btnSubmit = document.querySelector('.btn_submit');

	    // 개인정보 수정 버튼 클릭 시 이벤트 처리
	    btnSubmit.addEventListener('click', function(event) {
	        // 폼 전송 막기
	        event.preventDefault();

	        // 입력된 정보를 가져옴
	        const name = inputName.value;
	        const nick = inputNick.value;
	        const email = inputEmail.value;
	        const hp = inputHp.value;
	        const zip = inputZip.value;
	        const addr1 = inputAddr1.value;
	        const addr2 = inputAddr2.value;

	        // 입력된 정보를 alert에 표시
	        const message = 
	            `다음의 정보로 수정하시겠습니까?\n\n` +
	            `이름: ${name}\n` +
	            `별명: ${nick}\n` +
	            `이메일: ${email}\n` +
	            `휴대폰: ${hp}\n` +
	            `우편번호: ${zip}\n` +
	            `주소1: ${addr1}\n` +
	            `주소2: ${addr2}`;

	        if (confirm(message)) {
	            // 사용자가 확인을 누르면 폼을 제출
	            document.querySelector('form').submit();
	        } else {
	            // 취소를 누르면 아무것도 하지 않음
	            return false;
	        }
	    });

	    // 비밀번호 확인 버튼 클릭 시 이벤트 처리
	    btnModify.addEventListener('click', function() {
	        checkPasswordMatch();
	    });
	    
	    
	    
	    let preventDblClick = false;
		
		btnSendEmail.onclick = async function(){
			
			const email = registerForm.email.value;
			// 이중 클릭 방지
			if(preventDblClick){
				return;
			}
			
			// 이메일 유효성 검사
			if(!email.match(reEmail)){
				resultEmail.innerText = "유효한 이메일이 아닙니다.";
				resultEmail.style.color = "red";
				
				return;
			}
			
			try {
				preventDblClick = true;
				
				const response = await fetch('/FarmStory/member/checkUser.do?type=email&value='+email);
				const data = await response.json();
				console.log(data);	
				if(data.result > 0){
					
					resultEmail.innerText = "이미 사용중인 이메일 입니다.";
					resultEmail.style.color = "red";
					
				}else{
					resultEmail.innerText = "이메일 인증코드를 확인해주세요.";
					resultEmail.style.color = "green";
					
					auth.style.display = "inline";
				}
				
			} catch (e) {
				console.log(e);				
			}
			
		}// end email
		
		btnAuthEmail.onclick = function(){

			const code = registerForm.auth.value;
			
			fetch('/FarmStory/member/checkUser.do', {
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
	    

	   
	    
	    
	}
  function postcode() {
      new daum.Postcode({
          oncomplete: function(data) {
              // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

              // 각 주소의 노출 규칙에 따라 주소를 조합한다.
              // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
              var addr = ''; // 주소 변수
              var extraAddr = ''; // 참고항목 변수

              //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
              if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                  addr = data.roadAddress;
              } else { // 사용자가 지번 주소를 선택했을 경우(J)
                  addr = data.jibunAddress;
              }

              // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
              if(data.userSelectedType === 'R'){
                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                  // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                  if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                      extraAddr += data.bname;
                  }
                  // 건물명이 있고, 공동주택일 경우 추가한다.
                  if(data.buildingName !== '' && data.apartment === 'Y'){
                      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                  }
                  // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                  if(extraAddr !== ''){
                      extraAddr = ' (' + extraAddr + ')';
                  }
                  // 조합된 참고항목을 해당 필드에 넣는다.
                  //document.getElementById("sample6_extraAddress").value = extraAddr;
              
              } else {
                  document.getElementById("sample6_extraAddress").value = '';
              }

              // 우편번호와 주소 정보를 해당 필드에 넣는다.
              document.getElementById('zip').value = data.zonecode;
              document.getElementById("addr1").value = addr;
              // 커서를 상세주소 필드로 이동한다.
              document.getElementById("addr2").focus();
          }
      }).open();
  }

  
  </script>
 
        <main>
            <div class="mainIn">
               <section class="infotable">
                <div class="form">
                    <span>회원정보 설정</span>
                    <table>
                      <tr>
                        <th>아이디</th>
                        <td><span>${sessUser.uid }</span></td>
                      </tr>
                      <tr>
                        <th>비밀번호</th>
                        <td>
                            <div class="form_group">
                                <input type="password" id="input_password" placeholder="비밀번호 입력">
                            </div>
                        </td>
                      </tr>
                      <tr>
                        <th>비밀번호 확인</th>
                        <td>
                            <div class="form_group">
                                <input type="password" id="input_password_confirm" placeholder="비밀번호 입력확인">
                                <button type="button" class="btn_modifty"><p>비밀번호 수정</p></button>
                                <span class="resultPass"></span>
                            </div>
                        </td>
                      </tr>
                      <tr>
                        <th>회원가입날짜</th>
                        <td><span>${sessUser.regDate }</span></td>
                      </tr>
                    </table>

                    <span>개인정보 수정</span>
                    <form  action="/FarmStory/member/myInfo.do" method="post" enctype="multipart/form-data" >
	                    <table>
	                        <tr>
	                            <th>이름</th>
	                            <td class="form_group"><input type="text" id="input name" name="name" placeholder="${sessUser.name }" readonly></td>
	                        </tr>
	                        <tr>
	                            <th>별명</th>
	                            <td class="form_group">
	                                <ul>
	                                    <li><p>공백없는 한글, 영문, 숫자 입력</p></li>
	                                    <li>
	                                        <input type="text" id="input nickname" name="nick" placeholder="${sessUser.nick }" readonly>
	                                        <button type="button" class="btn_duplicate" placeholder="별명 입력"> <img src="../images/chk_id.gif" alt="Duplicate Check" class="icon"></button>
	                                    </li>
	                                </ul>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>이메일</th>
	                            <td class="form_group">
	                            	 <input type="email" name="email"  id="input email" placeholder="${sessUser.email }" readonly/>
			                        <button type="button" id="btnSendEmail"  class="btn_send"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
			                        <span class="resultEmail"></span>
			                        <div class="auth" style="display:none">
			                            <input type="text" name="auth" placeholder="인증번호 입력" />
			                            <button type="button" id="btnAuthEmail"  class="btn_auth" ><img src="../images/chk_confirm.gif" alt="확인"/></button>
			                        </div>	                            	
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>휴대폰</th>
	                            <td class="form_group">
	                                <input type="tel" id="input tel" name="hp" placeholder="${sessUser.hp }">
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>주소</th>
	                            <td class="form_group">
	                                <div class="address">
                                        <input type="text" name="zip" id="zip" placeholder="${sessUser.zip }" readonly/>                                
	                                    <button type="button" class="btnZip"> <img src="../images/chk_post.gif" alt="Postal check" class="icon" alt="우편번호 버튼"></button>
                                    </div>                            
                                    <div class="address">
	                                    <input type="text" id="input_address1" class="input_address" name="addr1" placeholder="${sessUser.addr1 }" readonly>
	                                </div>
	                                <div class="address">
	                                    <input type="text" id="input_address2" class="input_address" name="addr2" placeholder="${sessUser.addr2 }" readonly>
	                                </div>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th>회원탈퇴</th>
	                            <td class="form_group quit">
	                                <button type="button" class="btn_quit"><p>탈퇴하기</p></button>
	                            </td>
	                        </tr>
	                    </table>
		                </div>
		                <div class="button_container">
		                    <button type="button" class="btn-cancel">취소</button>
		                    <button type="submit" class="btn_submit">회원정보 수정</button>
		                </div>
               		</form>
            </section>
            </div>
        </main>

	<%@ include file="./_footer.jsp" %>

