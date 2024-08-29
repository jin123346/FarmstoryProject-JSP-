<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- croptalk aside : 농작물이야기 -->
<!-- #main -->
  <main id="main cf">
      <section class="mainIn cf">
          <div class="sub_bg">
              <img src="/FarmStory/images/sub_top_tit3.png" alt="Croptalk" class="sub_tit">
          </div>
          <aside class="aside">
              <div class="sidebar">
                  <div class="aside_cate">
                      <img src="/FarmStory/images/sub_aside_cate3_tit.png" alt="Croptalk 농작물이야기">
                  </div><!-- .aside_cate -->
                  <div class="aside_bg">
                      <ul class="cate_lnb1">
	                       <li><a href="/FarmStory/community/notice/list.do?group=croptalk&cate=b201" class="lnb1">농작물이야기</a></li>
	                       <li><a href="/FarmStory/community/notice/list.do?group=croptalk&cate=b202" class="lnb2">텃밭가꾸기</a></li>
	                       <li><a href="/FarmStory/community/notice/list.do?group=croptalk&cate=b203" class="lnb3">귀농학교</a></li>
                      </ul><!-- .cate_lnb -->
                  </div><!-- .aside_bg -->
              </div><!-- .sidebar -->
          </aside><!-- .aside -->
          
          <article class="article"><!-- .article start-->
              <div class="articleIn"><!-- .articleIn start-->
                  <nav>
                      <h2>
                      	<c:choose>
                            	<c:when test="${cate eq 'b201'}">
                            		<img src="/FarmStory/images/sub_nav_tit_cate3_tit1.png" alt="농작물이야기">
								</c:when>
                            	<c:when test="${cate eq 'b202'}">
                            		<img src="/FarmStory/images/sub_nav_tit_cate3_tit2.png" alt="텃밭가꾸기">
								</c:when>
                            	<c:otherwise>
                            		<img src="/FarmStory/images/sub_nav_tit_cate3_tit3.png" alt="귀농학교">
								</c:otherwise>
						</c:choose>
                      </h2>
                      <p class="location">
                          <img src="/FarmStory/images/sub_page_nav_ico.gif" alt="메뉴">
                          <span>HOME </span>
                          <span>농작물이야기 </span>
                          <c:choose>
                            	<c:when test="${cate eq 'b201'}">
                            		<strong>농작물이야기</strong> 
								</c:when>
                            	<c:when test="${cate eq 'b202'}">
                            		<strong>텃밭가꾸기</strong> 
								</c:when>
                            	<c:otherwise>
                            		<strong>귀농학교</strong> 
								</c:otherwise>
						</c:choose>
                      </p><!-- .location end-->
                  </nav>