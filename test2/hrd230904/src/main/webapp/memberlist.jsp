<%@page import="dto.MemberVO"%>
<%@page import="dto.TutorVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
	section{
		background-color: gray;
		width: 100%;
		height: 100%;
		position: fixed;
	}
	.title{
		margin: 2rem;
		font-size: 25px;
		font-weight: 900;
		text-align: center;
	}
	.wrapper{
		display: flex;
		justify-content: center;
		align-items: center;
		text-align: center;
	}
	
	table,th,td{
		border-collapse: collapse;
		border: 1px solid;
	}
	th,td{
		padding: 0.5rem;
	}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<section>
		<div class="title">
			회원정보조회
		</div>
		<div class="wrapper">
			<table border="1">
				<tr>
					<th>수강월</th>
					<th>회원번호</th>
					<th>회원명</th>
					<th>강의명</th>
					<th>강의장소</th>
					<th>수강료</th>
					<th>등급</th>
				</tr>
				<%
					for(int i = 0; i < list.size(); i++){
				%>
				<tr>
					<td><%= list.get(i).getRegist_month()%></td>
					<td><%= list.get(i).getC_no()%></td>
					<td><%= list.get(i).getC_name()%></td>
					<td><%= list.get(i).getClass_name()%></td>
					<td><%= list.get(i).getClass_area()%></td>
					<td><%= list.get(i).getTuition()%></td>
					<td><%= list.get(i).getGrade()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		
		
	</section>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>