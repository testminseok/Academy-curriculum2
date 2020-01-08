<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form role="form" method="post" autocomplete="off">
	<p>
		<label for="userName">닉네임</label>
		<input type="text" id="userName" name="userName" value="${member.userName }">
	</p>
	<p>
		<label for="userPass">새로운 비밀번호</label>
		<input type="password" id="userPass" name="userPass">
	</p>
	
	<p>
		<button type="submit">회원정보 수정</button>
	</p>
	<p>
		<a href="/">처음으로</a>
	</p>
	
</form>
</body>
</html>