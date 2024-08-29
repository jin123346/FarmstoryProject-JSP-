<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file="./_header.jsp" %>
<title>아이디찾기</title>
<link rel="stylesheet" href="../css/user/findidresult.css">
<script>

</script>
        <main id="main" class="cf">
            <div class="mainIn">
          <div class="container">
            <form>
            <section>
                <div class="top_txt">
                    <span>아이디 찾기 결과</span>
                </div>
           		<c:if test="${not empty user}">
	                <table>
	                    <tr>
	                        <td>이름</td>
	                        <td>
	                            <p><span>${user.name }</span></p>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>아이디</td>
	                        <td>
	                            <p><span>${user.uid }</span></p>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>이메일</td>
	                        <td>
	                            <p><span>${user.email }</span></p>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>가입일</td>
	                        <td>
	                            <p><span>${user.regDate }</span></p>
	                        </td>
	                    </tr>
	                </table>
                </c:if>
            </section>
    		<c:if test="${empty user }">
    			<div class="note" id="note" >
                고객님의 정보와 일치하는 아이디가 없습니다.
            	</div>
    		</c:if>
            <c:if test="${empty user }">
            	<div class="btns">
	                <a href="/FarmStory/member/findId.do" class=btn1>아이디찾기</a>
	                <a href="/FarmStory/member/terms.do" class=btn2>회원가입</a>
           		 </div>
            </c:if>
            <c:if test="${!empty user}">
            	 <div class="btns">
	                <a href="/FarmStory/member/login.do" class=btn3>로그인</a>
	                <a href="/FarmStory/member/findPass.do" class=btn4>비밀번호찾기</a>
           		 </div>
            </c:if>
           
            
    
        
            </form>
        </div>
                
                
            </div>
        </main>

	<%@ include file="./_footer.jsp" %>

