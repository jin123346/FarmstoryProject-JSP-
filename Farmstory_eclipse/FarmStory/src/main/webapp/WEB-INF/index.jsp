<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>

		
                
        <main id="main ">
            <section class="sub_bg">
                <article>
                     <img src="/FarmStory/images/main_slide_img1.jpg" alt="main slid image">
                     <img src="/FarmStory/images/main_slide_img_tit.png" alt="사람과 자연을 사랑하는 팜스토리 건강한 흙과 친환경만을 연구합니다." class="mainbntit">
                     <img src="/FarmStory/images/main_banner_bg.jpg" alt="grand open" class="bannerbg">
                     <div class="main_banner">
	                    <img src="/FarmStory/images/main_banner_img.png" alt="사과배 사진" class="bannerimg">
	                    <img src="/FarmStory/images/main_banner_tit.png" alt="팜스토리오픝기념 30%할인 이벤트" class="bannertit">
	                    <img src="/FarmStory/images/main_banner_txt.png" alt="grand open" class="bannertxt">
                     </div>
                </article>
            </section>
            <section class="mainIn ">
                <div class="maintit">
                    <img src="/FarmStory/images/main_market_tit.png" alt="장보기 베스트 상품을 소개합니다.">
                </div><!-- .maintit end -->

                <section class="market">
                    <article>
                        <a href="">
                            <img src="/FarmStory/images/market_item6.jpg" alt="과일 샘플 이미지">
                            <div class="mtxt">
                                <span>과일</span>
                                <p class="prodname">사과 500g</p>
                                <p class="del">4,000</p>
                                <p class="price"><strong>3,600원</strong></p>
                            </div>

                        </a>
                    </article>
                    <article>
                        <a href="">
                            <img src="/FarmStory/images/market_item5.jpg" alt="과일 샘플 이미지">
                            <div class="mtxt">
                                <span>과일</span>
                                <p class="prodname">사과 500g</p>
                                <p class="del">4,000</p>
                                <p class="price"><strong>3,600원</strong></p>
                            </div>

                        </a>
                    </article>
                    <article>
                        <a href="">
                            <img src="/FarmStory/images/market_item4.jpg" alt="과일 샘플 이미지">
                            <div class="mtxt">
                                <span>과일</span>
                                <p class="prodname">사과 500g</p>
                                <p class="del">4,000</p>
                                <p class="price"><strong>3,600원</strong></p>
                            </div>

                        </a>
                    </article>
                    <article>
                        <a href="">
                            <img src="/FarmStory/images/market_item3.jpg" alt="과일 샘플 이미지">
                            <div class="mtxt">
                                <span>과일</span>
                                <p class="prodname">사과 500g</p>
                                <p class="del">4,000</p>
                                <p class="price"><strong>3,600원</strong></p>
                            </div>

                        </a>
                    </article>
                    <article>
                        <a href="">
                            <img src="/FarmStory/images/market_item2.jpg" alt="과일 샘플 이미지">
                            <div class="mtxt">
                                <span>과일</span>
                                <p class="prodname">사과 500g</p>
                                <p class="del">4,000</p>
                                <p class="price"><strong>3,600원</strong></p>
                            </div>

                        </a>
                    </article>
                    <article class="last">
                        <a href="">
                            <img src="/FarmStory/images/market_item1.jpg" alt="과일 샘플 이미지">
                            <div class="mtxt">
                                <span>과일</span>
                                <p class="prodname">사과 500g</p>
                                <p class="del">4,000</p>
                                <p class="price"><strong>3,600원</strong></p>
                            </div>

                        </a>
                    </article>
                </section><!-- .market section end-->
                <section class="ad">
                    <article class="ad1">
                        <a href="/FarmStory/community/notice/list.do?group=community&cate=b102"><img src="/FarmStory/images/main_banner_sub1_tit.png" alt="팜스토리 오늘의 식단"></a>
                    </article>
                    <article class="ad2">
                        <a href="/FarmStory/community/notice/list.do?group=community&cate=b103"><img src="/FarmStory/images/main_banner_sub2_tit.png" alt="팜스토리 나도 요리사"></a>
                    </article>
                </section> <!-- .ad end-->

                <section class="crop">
                    <article class="garden">
                        <a href="#"><img src="/FarmStory/images/main_latest1_tit.png" alt="텃밭가꾸기"></a>
                        <img src="/FarmStory/images/main_latest1_img.jpg" alt="텃밭가꾸기">
                        <table>
						    <c:forEach var="garden" items="${garden}" varStatus="status">
						        <c:if test="${status.count <= 5}">
						            <tr>
						                <th>></th>
						                <td class="txt_line"><a href="/FarmStory/community/notice/view.do?boardNo=${garden.boardNo}&group=croptalk&cate=${garden.b_cateNo}">${garden.title}</a></td>
						                <td>${garden.b_rdate}</td>
						            </tr>
						        </c:if>
						    </c:forEach>
						</table>
                    </article>
                    <article class="returnfarm">
                        <a href="#"><img src="/FarmStory/images/main_latest2_tit.png" alt="귀농학교"></a>
                        <img src="/FarmStory/images/main_latest2_img.jpg" alt="귀농학교">
                        <table>
						    <c:forEach var="returnfarm" items="${returnfarm}" varStatus="status">
						        <c:if test="${status.count <= 5}">
						            <tr>
						                <th>></th>
						                <td class="txt_line"><a href="/FarmStory/community/notice/view.do?boardNo=${returnfarm.boardNo}&group=croptalk&cate=${returnfarm.b_cateNo}">${returnfarm.title}</a></td>
						                <td>${returnfarm.b_rdate}</td>
						            </tr>
						        </c:if>
						    </c:forEach>
						</table>
                    </article>
                    <article class="croptalk">
                        <a href="#"><img src="/FarmStory/images/main_latest3_tit.png" alt="농작물이야기"></a>
                        <img src="/FarmStory/images/main_latest3_img.jpg" alt="농작물 이야기">
                            <input type="hidden" name="b_cateNo" value="${cate}"/>
                       		<input type="hidden" name="group" value="${group}"/>
                        <table>
						    <c:forEach var="croptalk" items="${croptalk}" varStatus="status">
						        <c:if test="${status.count <= 5}">
						            <tr>
						                <th>></th>
						                <td class="txt_line"><a href="/FarmStory/community/notice/view.do?boardNo=${croptalk.boardNo}&group=croptalk&cate=${croptalk.b_cateNo}">${croptalk.title}</a></td>
						                <td>${croptalk.b_rdate}</td>
						            </tr>
						        </c:if>
						    </c:forEach>
						</table>
                    </article>
                </section>
                <section class="notice">
                    <article class="cs">
                        <div class="ntitle">
                            <img src="/FarmStory/images/main_sub2_cs_tit.png" alt="고객센터안내">
                        </div>
                        <div class="cstxt">
                            <img src="/FarmStory/images/main_sub2_cs_img.png" alt="전화기">

                            <img src="/FarmStory/images/main_sub2_cs_txt.png" alt="고객센터 전화번호 1666-777">
                            
                            <p class="cs_time">
                                평일: AM 09:00 ~ PM 06:00<br>
                                점심: PM 12:00 ~ PM 01:00<br>
                                토, 일요일, 공휴일 휴무<br>
                            </p>
                        </div>
                        <div class="cslink">
                            <a href="/FarmStory/community/notice/list.do?group=community&cate=b104"><img src="/FarmStory/images/main_sub2_cs_bt1.png" alt="1:1고객문의"></a>
                            <a href="/FarmStory/community/notice/list.do?group=community&cate=b105"><img src="/FarmStory/images/main_sub2_cs_bt2.png" alt="자주묻는 질문"></a>
                            <a href="#"><img src="/FarmStory/images/main_sub2_cs_bt3.png" alt="배송 조회"></a>
                        </div>

                    </article>
                    <article class="account">
                        <div class="ntitle">
                            <img src="/FarmStory/images/main_sub2_account_tit.png" alt="계좌안내">
                        </div>
                        <div class="accounttxt">
                            <p>
                                기업은행 123-456789-01-01-012<br>
                                국민은행 01-1234-56789<br>
                                우리은행 123-456789-01-01-012<br>
                                하나은행 123-456789-01-01<br>
                                예 금 주 (주)팜스토리
                            </p>
                        </div>

                    </article>
                    <article class="announcement">
                        <div class="ntitle">
                            <img src="/FarmStory/images/main_sub2_notice_tit.png" alt="공지사항">
                        </div>
                        <div class="ntable">
                            <table class="ntable">
						    <c:forEach var="notice" items="${notice}" varStatus="status">
						        <c:if test="${status.count <= 5}">
						            <tr>
						                <th>·</th>
						                <td class="txt_line"><a href="/FarmStory/community/notice/view.do?boardNo=${notice.boardNo}&group=community&cate=${notice.b_cateNo}">${notice.title}</a></td>
						                <td>${notice.b_rdate}</td>
						            </tr>
						        </c:if>
						    </c:forEach>
						</table>
                        </div>
                    </article>

                </section><!--.notice end-->

            </section><!--.mainin end-->
        </main ><!-- #main -->

   <%@ include file="./_footer.jsp" %>
       