<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../images/fav.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/user/login.css">
    <link rel="stylesheet" href="../css/user/register.css">
  	<link rel="stylesheet" href="../css/user/terms.css">
    <link rel="stylesheet" href="../css/footer.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 
        작업내용 
        2024/08/26  하진희 login html, css update
    -->
  
   

</head>
<body>
    <div id="wrapper">

        <header id="header">
            <div class="headerIn">
            	<div class="topline">
                    <img src="/FarmStory/images/head_top_line.png" alt="topline"/>
                </div><!-- .topLine -->
                <div class="logo">
                    <a href="/FarmStory/main.do"><img src="/FarmStory/images/logo.png" alt="farmStory logo"></a>
                </div><!-- .logo -->
                
                 <ul class="utill">
                    <li><a href="/FarmStory/main.do" id="home">HOME</a></li>
                   <c:choose>
                     <c:when test="${not empty sessUser}">
                            <li><a href="/FarmStory/member/logout.do" id="login">로그아웃</a></li>
                            <c:choose>
                                <c:when test="${sessUser.gradeNo == '00'}">
                                    <li><a href="/FarmStory/admin/index.do" id="register">관리자</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="/FarmStory/member/myInfo.do?uid=${sessUser.uid}" id="register">마이페이지</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/FarmStory/member/login.do" id="login">로그인</a></li>
                            <li><a href="/FarmStory/member/terms.do" id="register">회원가입</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b104" id="cs">고객센터</a></li>
                </ul><!-- .utill -->
                
                <div class="h_txt">
                    <img src="/FarmStory/images/head_txt_img.png" alt="3만원이상 무료배송·팜카드 10%적립">
                </div><!-- .h_txt -->
                
                <nav class="gnb_wrap">
                    <ul class="gnb">
                        <li><a href="/FarmStory/intro/introduction.do"><img src="/FarmStory/images/head_menu1.png" alt="팜스토리소개"></a></li>
                        <li><a href="/FarmStory/market/list.do?uid=${sessUser.uid}">
                            <img src="/FarmStory/images/head_menu_badge.png" alt="30%" class="discount"/>
                            <img src="/FarmStory/images/head_menu2.png" alt="장보기">
                        </a></li>
                        <li><a href="/FarmStory/community/notice/list.do?group=croptalk&cate=b201"><img src="/FarmStory/images/head_menu3.png" alt="농작물이야기"></a></li>
                        <li><a href="/FarmStory/community/notice/list.do?group=event&cate=b301"><img src="/FarmStory/images/head_menu4.png" alt="이벤트"></a></li>
                        <li><a href="/FarmStory/community/notice/list.do?group=community&cate=b101"><img src="/FarmStory/images/head_menu5.png" alt="커뮤니티"></a></li>
                    </ul><!-- .gnb -->
                </nav><!-- .gnb_wrap -->
                
            </div><!-- .headerIn -->
        </header><!-- #header -->