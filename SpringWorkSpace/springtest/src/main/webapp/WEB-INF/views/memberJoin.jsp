<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			label {
				display: inline-block;
				width: 30px;
			}
		</style>
	</head>
	<body>
		<h2>로그인 페이지</h2>
		
		<form name="frm" method="post" action="<%=request.getContextPath()%>/member/joinAction.do">
			<label for="memberName">name: </label><input id="memberName" type="text" name="memberName"><br>
			<label for="memberId">id: </label><input id="memberId" type="text" name="memberId"><br>
			<label for="memberPw">pw: </label><input id="memberPw" type="password" name="memberPw"><br>
			<input type="submit" value="회원가입">
		</form>
		
		<br>
		<a href="<%=request.getContextPath()%>/index.jsp">메인으로</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardList.do">목록으로</a>&emsp;
	</body>
</html>