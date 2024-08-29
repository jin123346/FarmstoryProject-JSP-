<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../_header.jsp" %>
<title>글보기</title>
<link rel="stylesheet" href="../../css/community.css">
<%@ include file="../../_aside_cm.jsp" %>
   <script>
	window.onload = function(){
		
		const commentForm = document.commentForm;
        const commentList= document.getElementsByClassName('commentList')[0];
        const commentRemove = document.getElementsByClassName('commentRemove');
        const commentModify = document.getElementsByClassName('commentModify');
        const btndelete = document.querySelector('.btnDelete');
        let originalText='';
        
        
        //동적 이벤트 처리
        document.addEventListener('click',function(e){
        
        	
        	//삭제 
        	 if (e.target.classList.contains('btnDelete')) {
        		console.log('e.target.dataset :' + e.target.dataset);
		        const articleNo = e.target.dataset.articleNo;
		        console.log(articleNo);
		    }
        	
        	//수정완료
        	if(e.target.classList == 'commentUpdate'){
				e.preventDefault();

        		const article = e.target.closest('article');
				const textarea = article.querySelector('textarea');
			
				
				const no = e.target.dataset.no;
			
        		const comment = textarea.value;
        		const formData = new FormData();
        		formData.append("comment",comment);
        		formData.append("no",no);
        		
        		
        		fetch('/FarmStory/comment/modify.do',{
        			method:'POST',
        			body: formData
        		})
        			.then(resp => resp.json())
        			.then(data => {
        				console.log(data);
        				if(data.result > 0){
        					alert('댓글이 수정되었습니다.');
        					
        					textarea.value=comment;
        					
    						textarea.readOnly = true;
    						textarea.style.background='transparent';
    						textarea.style.border = 'none';
    						e.target.style.display='none';
    						article.querySelector('.commentModify').innerText = '수정';
    						
        				}else{
        					alert('댓글 수정에 실패했습니다.')
        					textarea.value=originalText;
        				}
        				
        			})
        			.catch(err=>{})
        	}
        	
        	
        	
        	//댓글 수정 $ 취소 
        	if(e.target.classList == 'commentModify'){
				e.preventDefault();
				
				const article = e.target.closest('article');
				const textarea = article.querySelector('textarea');
				
				 const commentUpdate = article.querySelector('.commentUpdate');
				console.log(commentUpdate);
				
				const mode = e.target.innerText;
				
				console.log(textarea);
				
				if(mode=='수정'){
					originalText= textarea.value;
					textarea.readOnly = false;
					textarea.style.background='white';
					textarea.style.border = '1px solid black';
					textarea.focus();
					e.target.innerText='취소';
				 	commentUpdate.style.display = 'inline';
					
				}else{
					textarea.value = originalText;
					textarea.readOnly = true;
					textarea.style.background='transparent';
					textarea.style.border = 'none';
					e.target.innerText='수정';
					commentUpdate.style.display = 'none';
				}
				
        	}
        	
        	
        	
        	//댓글 삭제 
        	if(e.target.classList == 'commentRemove'){
				e.preventDefault();
			
					//삭제여부 확인 
					if(!confirm('정말 삭제하시겠습니까?')){
						return;
					}
					
					const article = e.target.closest('article');
					const no = e.target.dataset.no; // a태그 data-no 속성값 가져오기
					console.log(no);
	
					fetch('/FarmStory/comment/delete.do?no='+no)
						.then(resp => resp.json())
						.then(data => {
							console.log(data);
							
							if(data.result > 0){
								alert('댓글이 삭제되었습니다.');
								
								// 동적 삭제 처리
								article.remove();
								
							}else{
								alert('댓글이 삭제가 실패했습니다.');
							}
							
						})
						.catch(err => {
							console.log(err);
						});
					
	        	}
	        });
        
        
        //댓글 등록 
		commentForm.onsubmit=function(e){
			e.preventDefault();
			
			const com_parent = commentForm.com_parent.value;
			const com_writer= commentForm.com_writer.value;
			const comment = commentForm.comment.value;
			
			/* const jsonData = {
					"parent" : parent,
					"wirter" : writer,
					"comment": comment
			}; 
			json데이터로 넘기면 parameter로 받을 수 없다. 
			해결방법 :  formdata로 넘기기*/
			
			//formdata생성
			const formData = new FormData();
			formData.append("com_parent",com_parent);
			formData.append("com_writer",com_writer);
			formData.append("comment",comment);
			console.log(com_parent);
			console.log(com_writer);
			console.log(comment);
			
			
			fetch('/FarmStory/comment/write.do',{
					method:'POST',
					body : formData
				})
				.then(resp => resp.json())
				.then(data => {
					console.log(data);
					if(data != null){
						alert('댓글이 등록되었습니다.')
						/*등록된 댓글을 동적처리함  */
						//등록된 댓글 동적 태그 생성

						const commentArticle = `<article class="comment">
							                        <span>
							                            <span>\${data.com_rdate}</span>
							                            <span>\${data.com_writer}</span>
							                        </span>
							                        <textarea name="comment" readonly>\${data.com_content}</textarea>
							                        <div>
								                        <a href="#" class="commentRemove" data-no="${comment.comNo}">삭제</a>
							                            <a href="#" class="commentModify" data-no="${comment.comNo}">수정</a>
							                            <a href="#" class="commentUpdate" data-no="${comment.comNo}" style="display:none;">수정완료</a>
							                        </div>
						                    </article>`;	
						commentList.insertAdjacentHTML('beforeend', commentArticle);
						
						commentForm.reset();
						
					}else{
						alert('댓글 등록이 실패했습니다.')
					}
					
					
				})
				.catch(err=>{
					console.log(err);
				})
			
		}
		
	}
	
	</script>
                 	<section class="view">
				<h3>글보기</h3>
				<table>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"
							value="${boardDTO.title}" readonly /></td>
					</tr>
					<!-- 첨부파일이 있으면 나타나게끔  -->
					<c:if test="${boardDTO.b_fNo > 0}">
						<tr>
							<td>첨부파일</td>
							<td>
								<c:forEach var="file" items="${boardDTO.boardFiles}">
										<p style="margin: 4px 0">
											<a href="/FarmStory/community/notice/BoardFileDownload.do?b_fNo=${file.b_fNo}">${file.b_oName}</a>
											<span>${file.b_download}회 다운로드</span>
										</p>
								</c:forEach>
							</td>
						</tr>
					</c:if>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="b_contents" readonly>${boardDTO.b_contents}</textarea>
						</td>
					</tr>
				</table>
				 <div>
                    <a href="#" class="btnDelete" data-articleNo="${boardDTO.boardNo}">삭제</a>
                    <a href="#" class="btnModify" data-articleNo="${boardDTO.boardNo}">수정</a>
                    <a href="/FarmStory/community/notice/list.do" class="btnList">목록</a>
                </div>  

				 <!-- 댓글리스트 -->
                <section class="commentList">
                    <h3>댓글목록</h3>
                    <c:forEach var="comment" items="${comments}">
	                    <article class="comment">
		                   		 <span>
		                            <span>${comment.nick}</span>
		                            <span>${comment.com_rdate}</span>
		                        </span>
	                        <textarea name="comment" readonly>${comment.com_content}</textarea>
	                        
	                        <c:if test="${sessUser.uid eq comment.com_writer}">
		                        <div>
		                        	<!-- HTML 사용자 정의 속성을 이용한 삭제/수정 -->
		                            <a href="#" class="commentRemove" data-no="${comment.comNo}">삭제</a>
		                            <a href="#" class="commentModify" data-no="${comment.comNo}">수정</a>
		                            <a href="#" class="commentUpdate" data-no="${comment.comNo}" style="display:none;">수정완료</a>
		                        </div>
	                        </c:if>
	                    </article>
                    </c:forEach>
                    <c:if test="${empty comments}">
	                    <p class="empty">등록된 댓글이 없습니다.</p>
                    </c:if>
				</section>

				<!-- 댓글입력폼 -->
				<section class="commentForm">
					<h3>댓글쓰기</h3>
					<form name="commentForm">
						<input type="hidden" name="com_parent" value="${boardDTO.boardNo}" /> <input
							type="hidden" name="com_writer" value="${sessUser.uid}" />
						<textarea name="comment"></textarea>
						<div>
							<a href="#" class="btnCancel">취소</a> 
							<input type="submit" class="btnWrite" value="작성완료" />
						</div>
					</form>
				</section>
			</section>
        </main><!-- #main -->
        <!-- footer -->
<%@ include file="../../_footer.jsp" %>