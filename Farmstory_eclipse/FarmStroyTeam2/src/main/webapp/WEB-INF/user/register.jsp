<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../images/fav.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/footer.css">
     <link rel="stylesheet" href="../css/user/register.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
  
</head>
<body>
    <div id="wrapper">

        <header id="header">
            <div class="headerIn">
                <div class="logo">
                    <a href="#"><img src="../images/logo.png" alt="farmStory logo"></a>
                </div><!-- .logo -->
                 <ul class="utill">
                    <li><a href="#">HOME</a></li>
                    <li><a href="#">로그인</a></li>
                    <li><a href="#">회원가입</a></li>
                    <li><a href="#">관리자</a></li>
                    <li><a href="#">고객센터</a></li>
                </ul><!-- .utill -->
                <div class="h_txt">
                    <img src="../images/head_txt_img.png" alt="3만원이상 무료배송·팜카드 10%적립">
                </div><!-- .h_txt -->
                <nav class="gnb_wrap">
                    <ul class="gnb">
                        <li><a href="#"><img src="../images/head_menu1.png" alt="팜스토리소개"></a></li>
                        <li><a href="#">
                            <img src="../images/head_menu_badge.png" alt="30%" class="discount"/>
                            <img src="../images/head_menu2.png" alt="장보기">
                        </a></li>
                        <li><a href="#"><img src="../images/head_menu3.png" alt="농작물이야기"></a></li>
                        <li><a href="#"><img src="../images/head_menu4.png" alt="이벤트"></a></li>
                        <li><a href="#"><img src="../images/head_menu5.png" alt="커뮤니티"></a></li>
                    </ul><!-- .gnb -->
                </nav><!-- .gnb_wrap -->
            </div><!-- .headerIn -->
        </header><!-- #header -->
 
        <!-- main -->
        <main>
            <div class="mainIn">
                <section class="register">
                    <form action="#">
                        <table border="1">
                            <caption>사이트 이용정보 입력</caption>
                            <tr>
                                <td>아이디</td>
                                <td>
                                    <input type="text" name="uid" placeholder="아이디 입력"/>
                                    <button><img src="../images/chk_id.gif" alt=""></button>
                                    <span class="resultId"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>비밀번호</td>
                                <td>
                                    <input type="password" name="pass1" placeholder="비밀번호 입력"/>                            
                                </td>
                            </tr>
                            <tr>
                                <td>비밀번호 확인</td>
                                <td>
                                    <input type="password" name="pass2" placeholder="비밀번호 확인 입력"/>
                                    <span class="resultPass"></span>
                                </td>
                            </tr>
                        </table>
                        <table border="1">
                            <caption>개인정보 입력</caption>
                            <tr>
                                <td>이름</td>
                                <td>
                                    <input type="text" name="name" placeholder="이름 입력"/>                            
                                </td>
                            </tr>
                            <tr>
                                <td>별명</td>
                                <td>
                                    <p>공백없이 한글, 영문, 숫자만 입력가능</p>
                                    <input type="text" name="nick" placeholder="별명 입력"/>
                                    <span class="resultNick"></span>                            
                                </td>
                            </tr>
                            <tr>
                                <td>E-Mail</td>
                                <td>
                                    <input type="email" name="email" placeholder="이메일 입력"/>
                                </td>
                            </tr>
                            <tr>
                                <td>휴대폰</td>
                                <td>
                                    <input type="text" name="hp" placeholder="- 포함 13자리 입력" minlength="13" maxlength="13" />
                                </td>
                            </tr>
                            <tr>
                                <td>주소</td>
                                <td>
                                    <div>
                                        <input type="text" name="zip" placeholder="우편번호" readonly/>                                
                                        <button class="btnZip"><img src="../images/chk_post.gif" alt=""></button>
                                    </div>                            
                                    <div>
                                        <input type="text" name="addr1" placeholder="주소를 검색하세요." readonly/>
                                    </div>
                                    <div>
                                        <input type="text" name="addr2" placeholder="상세주소를 입력하세요."/>
                                    </div>
                                </td>
                            </tr>
                        </table>
        
                        <div>
                            <a href="#" class="btnCancel">취소</a>
                            <input type="submit"   class="btnSubmit" value="회원가입"/>
                        </div>    
                    </form>
                </section>
            </div>
        </main>  <!-- main end -->
        <footer id="footer">

            <div class="footerIn cf">
            <img src="../images/footer_logo.png" alt="farmStory footer" class="flogo">
            <div class="finfo">
                <span class="tel">(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-팜스토리구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호<br>
                    등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동 <br>
                    대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01&#41; 234-5678 / 경기도 성남시 잘한다구 신난다동 345
                </span><!-- .tel -->
                <p class="fcopy">Copyright(C)홍길동 All rights reserved.</p><!-- .fcopy -->
            </div><!-- .finfo -->
            

            </div><!-- .footerIn -->
        </footer><!-- footer -->
    </div>
    
</body>
</html>