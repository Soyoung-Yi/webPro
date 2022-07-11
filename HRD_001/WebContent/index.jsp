<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		section{width : 780px ; margin: 0 auto;  
			border: 1px solid blue;
			padding:10px;
			height:480px;
		}
		section ol { margin-left: 50px;}
	</style>
</head>
<body>
	<jsp:include page="main/header.jsp"/>
	<section>
		<h3>쇼핑몰 회원정보와 회원매출 정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다</h3>
		<h3>프로그램 작성 순서</h3>
		<ol>
			<li>회원정보 테이블을 생성한다</li>
			<li>매출정보 테이블을 생성한다</li>
			<li>회원정보, 매출정보 테이블에 제시된 문제지의 참조 데이터를 추가 생성한다</li>
			<li>회원정보 입력 화면 프로그램을 작성한다</li>
			<li>회원정보 조회 프로그램을 작성한다</li>
			<li>회원매출 정보 조회 프로그램을 작성한다</li>
		</ol>
	</section>
	<jsp:include page="main/footer.jsp"/>
</body>
</html>