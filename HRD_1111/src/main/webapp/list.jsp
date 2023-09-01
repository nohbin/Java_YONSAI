<%@page import="java.util.ArrayList"%>
<%@page import="dto.listVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	request.setCharacterEncoding("UTF-8");
	List<listVO> list = new ArrayList<>();
	list = (List<listVO>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	section{
		text-align: center;
		background-color: gray;
		top: 70px;
		width: 100%;
		height: 100%;
		position: fixed;
	}
	table{
		text-align: center;
		margin: auto;
		width: 1500px;
	}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<section>
		<h3>후보조회</h3>
		<table border="1">
			<tr>
				<th>후보번호</th>
				<th>성명</th>
				<th>소속정당</th>
				<th>학력</th>
				<th>주민번호</th>
				<th>지역구</th>
				<th>대표전화</th>
			</tr>
			<% for(int i = 0; i<list.size(); i++){ %>
			<tr>
				<td><%= list.get(i).getM_no() %></td>
				<td><%= list.get(i).getM_name() %></td>
				<td><%= list.get(i).getP_name() %></td>
				<td><%= list.get(i).getP_school() %></td>
				<td><%= list.get(i).getM_jumin() %></td>
				<td><%= list.get(i).getM_city() %></td>
				<td><%= list.get(i).getTel() %></td>
			</tr>
			<%} %>
			
		</table>
	</section>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>