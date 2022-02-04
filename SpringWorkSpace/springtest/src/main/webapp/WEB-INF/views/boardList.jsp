<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ezen.myapp.model.*" %>
<%
/* 리스트 값 받아서 뿌리기 */
//1. 값 받기
ArrayList<BoardVo> alist = (ArrayList<BoardVo>)request.getAttribute("alist");
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
				<td>Bidx 번호</td>
				<td>제목</td>
			</tr>
			<% //2. 값 뿌리기
			for(BoardVo item : alist) {%>
				<tr>
					<td><%=item.getBidx()%></td>
					<td><a href="<%=request.getContextPath()%>/board/boardContents.do?bidx=<%=item.getBidx()%>"><%=item.getSubject()%></a></td>
				</tr>
			<%}%>
		</table>
		
		<br>
		<a href="<%=request.getContextPath()%>/index.jsp">메인으로</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardWrite.do">글쓰기</a>
	</body>
</html>