<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>컨텐츠 페이지</h2>
		
		<table style="width:600px;"  border="1">
			<tr>
				<td>번호</td>
				<td>${ vo.bidx }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${ vo.subject }</td>
			</tr>
		</table>
		
		<br>
		<a href="<%=request.getContextPath()%>/index.jsp">메인으로</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardList.do">목록으로</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardModify.do?bidx=${ vo.bidx }">글수정</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardDelete.do?bidx=${ vo.bidx }">글삭제</a>
	</body>
</html>