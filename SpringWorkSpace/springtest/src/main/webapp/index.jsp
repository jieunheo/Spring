<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<h2>게시판 메인</h2>
		<p>회원 아이디: ${ login.memberId }</p>
		<p>회원 이름: ${ login.memberName }</p>
		
		<br>
		<a href="<%=request.getContextPath()%>/board/boardWrite.do">게시판 글쓰기</a>&emsp;
		<a href="<%=request.getContextPath()%>/board/boardList.do">목록으로</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/member/memberList.do">회원목록</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/member/login.do">로그인</a>&emsp;
		<a href="<%=request.getContextPath()%>/member/join.do">회원가입</a>
	</body>
</html>