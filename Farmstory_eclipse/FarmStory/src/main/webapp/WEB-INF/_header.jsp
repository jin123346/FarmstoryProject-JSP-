<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/FarmStory/images/fav.ico" type="image/x-icon">
    <link rel="stylesheet" href="/FarmStory/css/header.css">
    <link rel="stylesheet" href="/FarmStory/css/reset.css">
    <link rel="stylesheet" href="/FarmStory/css/common.css">
    <link rel="stylesheet" href="/FarmStory/css/style.css">
    <link rel="stylesheet" href="/FarmStory/css/footer.css">
    <link rel="stylesheet" href="FarmStory/css/introduction/introduction.css">
    <link rel="stylesheet" href="../css/introduction/direction.css">
    <link rel="stylesheet" href="../css/community.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <title>FarmStroy</title> -->
    
    <script>
    const  grade = '${requestScope.grade}';
   
     window.onload = function(){
    	 	const login= document.getElementById('login');
    	    const register= document.getElementById('register');
    	    console.log(login);
    	 
    	    if(grade ==='admin'){
    	        login.innerText="로그아웃";
    	        login.href="/FarmStory/member/logout.do";
    	        register.innerText="관리자";
    	        register.href="/FarmStory/admin/index.do";
    	    }else if(grade ==='user'){
    	        login.innerText="로그아웃";
    	        login.href="/FarmStory/member/logout.do";
    	        register.innerText="마이페이지";
    	        register.href="/FarmStory/main.do";
    	    }
     }
</script>

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
                    <li><a href="/FarmStory/member/login.do" id="login">로그인</a></li>
                    <li><a href="/FarmStory/member/terms.do" id="register">회원가입</a></li>
                    <li><a href="/FarmStory/community/cs.do" id="cs">고객센터</a></li>
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