<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>게시판 글쓰기</h2>
		
		<form name="frm" method="post" action="<%=request.getContextPath()%>/board/boardWriteAction.do">
			<input type="text" name="subject">
			<input type="submit" value="전송">
		</form>
		
		<br>
		<a href="<%=request.getContextPath()%>/index.jsp">메인으로</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardList.do">목록으로</a>
	</body>
</html>