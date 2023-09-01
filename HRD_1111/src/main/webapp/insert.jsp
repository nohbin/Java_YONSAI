<%@page import="java.util.ArrayList"%>
<%@page import="dto.listVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

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
		width: 500px;
	}
	
	table tr{
		left: 0; 
	}
</style>


<body>
<jsp:include page="header.jsp"></jsp:include>

<form action="TestServlet?command=insertDo" name="frm" method="post">
	<section>
		<h3>후보조회</h3>
		<table border="1">
			<tr>
				<td>주민번호</td>
				<td><input type="text" name="v_jumin"> 예: 8906153154726 </td>
			</tr>
			<tr>
				<td>성명</td>
				<td><input type="text" name="v_name"></td>
			</tr>
			<tr>
				<td>투표 번호</td>
				<td>
					<select name="m_no">
						<option selected="selected" ></option>
						<option value="1">[1] 김후보</option>
						<option value="2">[2] 이후보</option>
						<option value="3">[3] 박후보</option>
						<option value="4">[4] 조후보</option>
						<option value="5">[5] 최후보</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td>투표 시간</td>
				<td><input type="text" name="v_time"></td>
			</tr>
			<tr>
				<td>투표 장소</td>
				<td><input type="text" name="v_area">제 1투표장 or 제2 투표장</td>
			</tr>
			<tr>
				<td>유권자 확인</td>
				<td>
					<input type="radio" name="v_confirm" value="Y"> 확인
					<input type="radio" name="v_confirm" value="N"> 미확인
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" onclick="check()" value="투표하기"> 
					<button class="btn" type="button" onclick="fn_reset()">다시하기</button> 
				</td>
			</tr>
			
		</table>
	</section>
</form>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="script.js"></script>
</body>
</html>