# 🌾 팜스토리 (Farmstory) 프로젝트

<div align="center">

![프로젝트 로고](https://img.shields.io/badge/Farmstory-농산물_쇼핑몰-green?style=for-the-badge)

**JSP 기반 커뮤니티형 농산물 쇼핑몰 웹 애플리케이션**

</div>

---

## 📋 프로젝트 개요

**팜스토리**는 농산물을 온라인으로 판매하는 커뮤니티형 쇼핑몰입니다. 농부와 소비자를 직접 연결하여 신선한 농산물을 합리적인 가격에 제공하며, 커뮤니티 기능을 통해 농업 정보와 경험을 공유할 수 있는 플랫폼입니다.

| 항목 | 내용 |
|------|------|
| **프로젝트명** | 팜스토리 (Farmstory) |
| **프로젝트 유형** | 커뮤니티형 농산물 쇼핑몰 |
| **개발 기간** | 2025.05 ~ 2025.06 (2개월) |
| **팀 구성** | 3명 (프론트엔드 1명, 백엔드 2명) |
| **개발 환경** | Java 11, JSP, MySQL, Apache Tomcat |

---

## 🛠 기술 스택

### 🔧 백엔드 (Backend)
<div>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
<img src="https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white" alt="JSP">
<img src="https://img.shields.io/badge/Servlet-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Servlet">
<img src="https://img.shields.io/badge/JDBC-00618A?style=for-the-badge&logo=java&logoColor=white" alt="JDBC">
</div>

### 🎨 프론트엔드 (Frontend)
<div>
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white" alt="CSS3">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=black" alt="JavaScript">
<img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=Thymeleaf&logoColor=white" alt="Thymeleaf">
</div>

### 🗄 데이터베이스 (Database)
<div>
<img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
</div>

### 🚀 서버 & 도구 (Server & Tools)
<div>
<img src="https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black" alt="Tomcat">
<img src="https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white" alt="Eclipse">
<img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Maven">
</div>

---

## ⚡ 주요 기능

### 👤 사용자 기능 (User Features)

| 기능 카테고리 | 상세 기능 | 설명 |
|---------------|-----------|------|
| **회원 관리** | 회원가입 | 이메일 중복 확인, 입력 검증 |
| | 로그인/로그아웃 | 세션 관리, 자동 로그인 |
| | 마이페이지 | 개인정보 수정, 주문내역 조회 |
| **상품 관리** | 상품 목록 | 카테고리별 상품 조회 |
| | 상품 상세보기 | 상품 정보, 리뷰, 평점 확인 |
| | 상품 검색 | 키워드 기반 상품 검색 |
| **주문 관리** | 장바구니 | 상품 담기, 수량 변경, 삭제 |
| | 주문하기 | 배송지 입력, 결제 처리 |
| | 주문내역 | 주문 상태 확인, 배송 추적 |

### 💬 커뮤니티 기능 (Community Features)

| 기능 카테고리 | 상세 기능 | 설명 |
|---------------|-----------|------|
| **고객지원** | 공지사항 | 사이트 소식, 이벤트 공지 |
| | Q&A 게시판 | 1:1 문의, 답변 관리 |
| | FAQ | 자주 묻는 질문 목록 |
| **커뮤니티** | 자유게시판 | 농업 정보, 경험 공유 |
| | 후기게시판 | 상품 후기, 평점 작성 |

### 🛠 관리자 기능 (Admin Features)

| 기능 카테고리 | 상세 기능 | 설명 |
|---------------|-----------|------|
| **상품 관리** | 상품 등록 | 이미지 업로드, 카테고리 설정 |
| | 상품 수정/삭제 | 재고 관리, 가격 변경 |
| | 카테고리 관리 | 분류 체계 관리 |
| **회원 관리** | 회원 목록 | 회원 정보 조회, 상태 관리 |
| | 권한 관리 | 관리자 권한 부여/회수 |
| **주문 관리** | 주문 처리 | 주문 확인, 배송 관리 |
| | 매출 통계 | 일별/월별 매출 분석 |
| **게시판 관리** | 게시글 관리 | 부적절한 글 삭제, 공지 등록 |
| | 댓글 관리 | 댓글 승인/삭제 |

---

## 📁 프로젝트 구조

```
farmstory/
├── 📂 src/main/java/
│   ├── 📂 controller/          # 컨트롤러 (요청 처리)
│   │   ├── UserController.java
│   │   ├── ProductController.java
│   │   ├── OrderController.java
│   │   └── AdminController.java
│   ├── 📂 dao/                 # 데이터 접근 객체
│   │   ├── UserDAO.java
│   │   ├── ProductDAO.java
│   │   └── OrderDAO.java
│   ├── 📂 dto/                 # 데이터 전송 객체
│   │   ├── UserDTO.java
│   │   ├── ProductDTO.java
│   │   └── OrderDTO.java
│   ├── 📂 service/             # 비즈니스 로직
│   │   ├── UserService.java
│   │   ├── ProductService.java
│   │   └── OrderService.java
│   └── 📂 util/                # 유틸리티 클래스
│       ├── DBUtil.java
│       └── FileUtil.java
├── 📂 src/main/webapp/
│   ├── 📂 WEB-INF/
│   │   ├── web.xml
│   │   └── 📂 views/           # JSP 뷰 파일
│   │       ├── user/
│   │       ├── product/
│   │       ├── order/
│   │       └── admin/
│   ├── 📂 resources/
│   │   ├── 📂 css/             # 스타일시트
│   │   ├── 📂 js/              # 자바스크립트
│   │   └── 📂 images/          # 이미지 파일
│   └── 📂 upload/              # 업로드 파일
└── 📄 pom.xml                  # Maven 설정 파일
```

---

## 🎯 핵심 구현 사항

### 🔒 보안 기능
- **입력 데이터 검증**: XSS, SQL Injection 방지
- **세션 관리**: 로그인 상태 유지 및 보안
- **권한 관리**: 사용자/관리자 접근 권한 제어

### 📱 사용자 경험 (UX)
- **반응형 웹 디자인**: 모바일/태블릿/PC 대응
- **직관적인 UI**: 쉬운 네비게이션과 사용법
- **빠른 로딩 속도**: 이미지 최적화 및 캐싱

### 🔧 기술적 특징
- **MVC 패턴**: 유지보수성과 확장성 고려
- **커넥션 풀**: 데이터베이스 성능 최적화
- **파일 업로드**: 상품 이미지 관리 기능

---

## 📊 데이터베이스 설계

### 주요 테이블 구조

| 테이블명 | 주요 컬럼 | 설명 |
|----------|-----------|------|
| **users** | uid, name, email, password | 사용자 정보 |
| **products** | pid, name, price, category, stock | 상품 정보 |
| **orders** | oid, uid, total_price, order_date | 주문 정보 |
| **order_items** | oid, pid, quantity, price | 주문 상세 |
| **cart** | uid, pid, quantity | 장바구니 |
| **articles** | aid, title, content, writer | 게시글 |

---

## 🚀 배운 점 & 성과

### 💡 기술적 성장
- **JSP/Servlet 이해**: 웹 애플리케이션 동작 원리 습득
- **데이터베이스 설계**: 효율적인 테이블 구조 설계 경험
- **MVC 패턴**: 체계적인 코드 구조 이해

### 🤝 협업 경험
- **Git 협업**: 브랜치 전략과 코드 리뷰 경험
- **역할 분담**: 프론트엔드/백엔드 협업 프로세스 이해
- **의사소통**: 기술적 이슈 해결을 위한 팀 커뮤니케이션

### 🎯 문제 해결
- **성능 최적화**: 쿼리 최적화와 이미지 처리 개선
- **보안 강화**: 입력 검증과 세션 관리 구현
- **사용자 경험**: 직관적인 UI/UX 설계

---

## 🔗 관련 링크

- **GitHub Repository**: [프로젝트 코드 보기](https://github.com/username/farmstory)
- **라이브 데모**: [웹사이트 체험하기](https://farmstory-demo.com)
- **프로젝트 발표**: [발표 자료 보기](https://slides.com/farmstory-presentation)

---

<div align="center">

**📧 Contact**: your.email@example.com | **📱 Phone**: 010-1234-5678

*이 프로젝트를 통해 웹 개발의 전체적인 흐름을 이해하고, 실무에 필요한 기술들을 습득할 수 있었습니다.*

</div>
