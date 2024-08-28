<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="shortcut icon" href="../../images/fav.ico" type="image/x-icon">
    <link rel="stylesheet" href="../../css/reset.css">
    <link rel="stylesheet" href="../../css/header.css">
    <link rel="stylesheet" href="../../css/community.css">
    <link rel="stylesheet" href="../../css/footer.css">
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
</head>
<body>
    <div id="wrapper">
    
        <header id="header">
            <div class="headerIn">
                <div class="topline">
                    <img src="../../images/head_top_line.png" alt="topline"/>
                </div><!-- .topLine -->
                <div class="logo">
                    <a href="#"><img src="../../images/logo.png" alt="farmStory logo"></a>
                </div><!-- .logo -->
                 <ul class="utill">
                    <li><a href="#">HOME</a></li>
                    <li><a href="#">로그인</a></li>
                    <li><a href="#">회원가입</a></li>
                    <li><a href="#">고객센터</a></li>
                </ul><!-- .utill -->
                <div class="h_txt">
                    <img src="../../images/head_txt_img.png" alt="3만원이상 무료배송·팜카드 10%적립">
                </div><!-- .h_txt -->
                <nav class="gnb_wrap">
                    <ul class="gnb">
                        <li><a href="#"><img src="../../images/head_menu1.png" alt="팜스토리소개"></a></li>
                        <li><a href="#">
                            <img src="../../images/head_menu_badge.png" alt="30%" class="discount"/>
                            <img src="../../images/head_menu2.png" alt="장보기">
                        </a></li>
                        <li><a href="#"><img src="../../images/head_menu3.png" alt="농작물이야기"></a></li>
                        <li><a href="#"><img src="../../images/head_menu4.png" alt="이벤트"></a></li>
                        <li><a href="#"><img src="../../images/head_menu5.png" alt="커뮤니티"></a></li>
                    </ul><!-- .gnb -->
                </nav><!-- .gnb_wrap -->
            </div><!-- .headerIn -->
        </header><!-- #header -->

        <!-- #main -->
        <main id="main cf">
            <section class="mainIn cf">
                <div class="sub_bg">
                    <img src="../../images/sub_top_tit5.png" alt="COMMUNITY" class="sub_tit">
                </div>
                <aside class="aside">
                    <div class="sidebar">
                        <div class="aside_cate">
                            <img src="../../images/sub_aside_cate5_tit.png" alt="커뮤니티">
                        </div><!-- .aside_cate -->
                        <div class="aside_bg">
                            <ul class="cate_lnb">
                                <li> <a href="#">공지사항</a></li>
                                <li> <a href="#">오늘의식단</a></li>
                                <li> <a href="#">나도요리사</a></li>
                                <li> <a href="#">1:1고객문의</a></li>
                                <li> <a href="#">자주묻는질문</a></li>
                            </ul><!-- .cate_lnb -->
                        </div><!-- .aside_bg -->
                    </div><!-- .sidebar -->
                </aside><!-- .aside -->
                
                <article class="article">
                    <div class="articleIn">
                        <nav>
                            <h2>
                                <img src="../../images/sub_nav_tit_cate5_tit1.png" alt="공지사항">
                            </h2>
                            <p class="location">
                                <img src="../../images/sub_page_nav_ico.gif" alt="메뉴">
                                <span>HOME </span>
                                <span>커뮤니티 </span>
                                <strong>나도요리사</strong> 
                            </p>
                        </nav>
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
        <footer id="footer">

            <div class="footerIn cf">
            <img src="../../images/footer_logo.png" alt="farmStory footer" class="flogo">
            <div class="finfo">
                <span class="tel">(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호<br>
                    등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동 <br>
                    대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01&#41; 234-5678 / 경기도 성남시 잘한다구 신난다동 345
                </span><!-- .tel -->
                <p class="fcopy">Copyright(C)홍길동 All rights reserved.</p><!-- .fcopy -->
            </div><!-- .finfo -->
            
        
        </div><!-- .footerIn -->
        </footer><!-- footer -->

    </div><!-- #wrapper -->
</body>
</html>