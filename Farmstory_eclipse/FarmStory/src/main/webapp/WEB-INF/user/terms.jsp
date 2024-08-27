<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./_header.jsp" %>

<script>
	window.onload = function(){
		
		const btnNext = document.getElementsByClassName('btnNext')[0];
		
		
			btnNext.onclick = function(){
			
			const chk1 = document.getElementById('chk1');
			const chk2 = document.getElementById('chk2');
			
			const chk1_1 = chk1.checked;
			const chk2_1 = chk2.checked;
			
			if(chk1_1 && chk2_1){
				btnNext.href = "/FarmStory/member/register.do";	
				console.log("changed!!!");
			}else{
				alert('약관에 동의해주세요');
			}
		}
	}
</script>

        <main>
            <div class="mainIn">
                <section class="terms">
                    <table>
                        <caption>사이트 이용약관</caption>
                        <tr>
                            <td>
                                <textarea readonly>${termsDto.terms}</textarea>
                                <p>
                                    <label><input type="checkbox" name="chk1" id="chk1"/>동의합니다.</label>
                                </p>
                            </td>
                        </tr>
                    </table>
                    <table>
                        <caption>개인정보 취급방침</caption>
                        <tr>
                            <td>
                                <textarea readonly>${termsDto.privacy}</textarea>
                                <p>
                                    <label><input type="checkbox" name="chk2" id="chk2"/>동의합니다.</label>
                                </p>
                            </td>
                        </tr>
                    </table>
                    <div>
                        <a href="/FarmStory/member/login.do" class="btnCancel">취소</a>
                        <a href="#" class="btnNext">다음</a>
                    </div>
                </section>
            </div>
        </main><!-- main end -->
<%@ include file="./_footer.jsp" %>
    
</body>
</html>
