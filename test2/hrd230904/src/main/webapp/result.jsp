<%@page import="dto.ResultVO"%>
<%@page import="dto.TutorVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ResultVO> list = (List<ResultVO>)request.getAttribute("list");
	
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
			강사 조회
		</div>
		<div class="wrapper">
			<table border="1">
				<tr>
					<th>강사코드</th>
					<th>강의명</th>
					<th>강사명</th>
					<th>총매출</th>
				</tr>
				<%
					for(int i = 0; i < list.size(); i++){
				%>
				<tr>
					<td><%= list.get(i).getTeacher_code()%></td>
					<td><%= list.get(i).getClass_name()%></td>
					<td><%= list.get(i).getTeacher_name()%></td>
					<td><%= list.get(i).getTotal()%></td>
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