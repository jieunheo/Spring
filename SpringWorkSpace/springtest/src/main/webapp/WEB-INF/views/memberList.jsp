<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ezen.myapp.model.*" %>
<%
/* 리스트 값 받아서 뿌리기 */
//1. 값 받기
ArrayList<MemberVo> alist = (ArrayList<MemberVo>)request.getAttribute("alist");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>리스트 페이지</h2>
		
		<table style="width:600px;"  border="1">
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>가입일</td>
				<td>탈퇴여부</td>
			</tr>
			<% //2. 값 뿌리기
			for(MemberVo item : alist) {%>
				<tr>
					<td><%=item.getMidx()%></td>
					<td><%=item.getMemberId()%></td>
					<td><%=item.getMemberName()%></td>
					<td><%=item.getWriteday()%></td>
					<td><%=item.getDelYN()%></td>
				</tr>
			<%}%>
		</table>
		
		<br>
		<a href="<%=request.getContextPath()%>/index.jsp">메인으로</a>
	</body>
</html>