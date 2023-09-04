<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

*{
	margin: 0;
	padding: 0;
}

header{
	background-color: blue;
	width: 100%;
	margin: auto;
	text-align: center;
	top: 0;
	height: 100px;
	line-height: 100px;
}

nav{
	top: 100px;
	height: 50px;
	line-height: 50px;
	background-color: lime;
}

a{
	text-decoration: none;
	font-weight: 500;
}
</style>

<body>
	<header>
		<h1>골프연습장 회원관리 프로그램 ver 1.0</h1>
	</header>
	<nav>
		<a href="action?command=tutorlist">강사조회</a>
		<a href="action?command=insert">수강신청</a>
		<a href="action?command=memberlist">회원정보조회</a>
		<a href="action?command=tutorresult">강사매출현황</a>
		<a href="index.jsp">홈으로</a>
	</nav>
</body>
</html>