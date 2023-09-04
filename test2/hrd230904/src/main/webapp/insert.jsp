<%@page import="dto.TutorVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<TutorVO> list = (List<TutorVO>)request.getAttribute("list");
	
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
	td{
		text-align: left;
	
	}
</style>


<body onload="document.frm.regist_month.focus();">
	<jsp:include page="header.jsp"></jsp:include>
	
	<section>
		<div class="title">
			수강 신청
		</div>
		<div class="wrapper">
			<form action="action?command=insert.do" method="post" name="frm">
				<table>
					<tr>
						<th>수강월</th>
						<td><input type="text" name="regist_month">2022년03월 예)202203 </td>
					</tr>
					<tr>
						<th>회원명</th>
						<td>
							<select name="c_name" onchange="fn_change1()">
								<option value="">회원명</option>
								<option value="10001">홍길동</option>
								<option value="10002">장발장</option>
								<option value="10003">임꺽정</option>
								<option value="10001">성춘향</option>
								<option value="20002">이몽룡</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>회원번호</th>
						<td><input type="text" name="c_no" readonly> 예)100001 </td>
					</tr>
					<tr>
						<th>강의장소</th>
						<td>
							<select name="class_area">
								<option value="">	   강의장소</option>
								<option value="서울본원">서울본원</option>
								<option value="성남본원">성남본원</option>
								<option value="부산본원">부산본원</option>
								<option value="대구본원">대구본원</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>강의명</th>
						<td>
							<select name="teacher_code" onchange="fn_change2();">
								<option selected="selected">강의신청</option>
								<option value="100">초급반</option>
								<option value="200">중급반</option>
								<option value="300">고급반</option>
								<option value="400">심화반</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>수강료</th>
						<td>
							<input type="text" name="tuition" readonly="readonly">원
						</td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="2">
							<button type="submit"  onclick="fn_check(); return false;" >수강신청</button>
							<button type="button"  onclick="fn_reset()">다시쓰기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		
	</section>
	<script type="text/javascript">
	
		function fn_check(){
			
			var fn = document.frm;
			
			if(fn.regist_month.value === ""){
				alert("수강월을 입력해주세요");
				fn.regist_month.focus();
				return false;
			}else if(fn.c_no.value ===""){
				alert("회원명을 입력해주세요");
				fn.regist_month.focus();
				return false;
			}else if(fn.class_area.value === ""){
				alert("강의장소를 입력해주세요");
				fn.class_area.focus();
				return false;
			}else if(fn.tuotion.value ===""){
				alert("강의명을 입력해주세요");
				fn.teacher_code.focus();
				return false;
			}
			
			fn.submit();
			
		}
	
		function fn_reset(){
			if(confirm("정보를 지우고 다시 입력합니다!")){
				location = "insert.jsp"
			}
		}

		function fn_change1(){
			var fn = document.frm;
			
			fn.tuition.value="";
			fn.teacher_code[0].selected = true;
			
			fn.c_no.value = fn.c_name.value;
		}	
		
		function fn_change2(){
			var fn = document.frm;
			var price = fn.teacher_code.value * 1000;
			var c_no = fn.c_no.value;
			
			if(c_no>=20000){
				price *= 0.5;
			}
			fn.tuition.value = price;
		}
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>