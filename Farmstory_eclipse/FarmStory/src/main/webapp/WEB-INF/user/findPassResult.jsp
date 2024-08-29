<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="./_header.jsp" %>
<title>비밀번호변경</title>
<link rel="stylesheet" href="../css/user/findidresult.css">
<script>

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
	                            <p><span></span></p>
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

