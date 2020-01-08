<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KING 게시판</title>
</head>
<body>
<form role="form" method="post" autocomplete="off" >
	<p> 
		<label for="userId">아이디</label>
		<input type="text" id="userId" name="userId" value="${member.userId}">
	</p> 
	<p>
		<label for="userPass">비밀번호</label>
		<input type="password" id="userPass" name="userPass"/>
		<input type="hidden" value="${member.userPass}">
	</p> 
	<p>
		<button type="submit">회원탈퇴</button>
	</p>
	<p>
		<a href="/">처음으로</a>
	</p>
</form>

</body>
</html>