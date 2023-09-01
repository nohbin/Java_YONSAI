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
	padding: 0;
	margin: 0;
}
header{
	text-align: center;
	width: 100%;
	background-color: blue;
	color: white;
	height: 50px;
}
nav{
	background-color: lightblue;
	width: 100%;
	top:50px;
	
}
</style>
<body>

<header><h1>(과정평가형 정보처리산업기사) 지역구의원투표 프로그램 ver 2022-05</h1></header>
<nav>
	<a href="TestServlet?command=list">후보조회</a> 
	<a href="TestServlet?command=insertview">투표하기</a>
	<a href="TestServlet?command=check">투표점수조회</a>
	<a href="TestServlet?command=count">후보자등수</a>
	<a href="index.jsp">홈으로</a>
</nav>
</body>
</html>

