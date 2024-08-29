<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- community aside : 커뮤니티 -->
<!-- #main -->
    <main id="main cf">
        <section class="mainIn cf">
            <div class="sub_bg">
                <img src="/FarmStory/images/sub_top_tit5.png" alt="COMMUNITY" class="sub_tit">
            </div>
            <aside class="aside">
                <div class="sidebar">
                    <div class="aside_cate">
                        <img src="/FarmStory/images/sub_aside_cate5_tit.png" alt="커뮤니티">
                    </div><!-- .aside_cate -->
                    <div class="aside_bg">
                        <ul class="cate_lnb">
                            <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b101">공지사항</a></li>
                            <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b102">오늘의식단</a></li>
                            <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b103">나도요리사</a></li>
                            <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b104">1:1고객문의</a></li>
                            <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b105">자주묻는질문</a></li>
                        </ul><!-- .cate_lnb -->
                    </div><!-- .aside_bg -->
                </div><!-- .sidebar -->
            </aside><!-- .aside -->
            
            <article class="article"><!-- .article start-->
              <div class="articleIn"><!-- .articleIn start-->
                    <nav>
	                    <c:set var="h2_cate" value="" />
	                    <c:if test="${name eq '홍길동'}">    
	                    <c:out value="${str}" />
	                    </c:if>
                        <h2>
							<c:choose>
                            	<c:when test="${cate eq 'b101'}">
                            		<img src="/FarmStory/images/sub_nav_tit_cate5_tit1.png" alt="공지사항">
								</c:when>
                            	<c:when test="${cate eq 'b102'}">
                            		<img src="/FarmStory/images/sub_nav_tit_cate5_tit2.png" alt="오늘의식단">
								</c:when>
                            	<c:when test="${cate eq 'b103'}">
                            		<img src="/FarmStory/images/sub_nav_tit_cate5_tit3.png" alt="나도요리사">
								</c:when>
                            	<c:when test="${cate eq 'b104'}">
                            		<img src="/FarmStory/images/sub_nav_tit_cate5_tit4.png" alt="1:1고객문의">
								</c:when>
                            	<c:otherwise>
                            		<img src="/FarmStory/images/sub_nav_tit_cate5_tit5.png" alt="자주묻는질문">
								</c:otherwise>
							</c:choose>
                        </h2>
                        <p class="location">
                            <img src="/FarmStory/images/sub_page_nav_ico.gif" alt="메뉴">
                            <span>HOME </span>
                            <span>커뮤니티 </span>
                            <c:choose>
                            	<c:when test="${cate eq 'b101'}">
                            		<strong>공지사항</strong> 
								</c:when>
                            	<c:when test="${cate eq 'b102'}">
                            		<strong>오늘의식단</strong> 
								</c:when>
                            	<c:when test="${cate eq 'b103'}">
                            		<strong>나도요리사</strong> 
								</c:when>
                            	<c:when test="${cate eq 'b104'}">
                            		<strong>1:1고객문의</strong> 
								</c:when>
                            	<c:otherwise>
                            		<strong>자주묻는질문</strong> 
							</c:otherwise>
						</c:choose>
                        </p>
                    </nav>