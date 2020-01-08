<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 -->
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="root">
		<header>
			<%@ include file="include/header.jsp" %>
		</header>
		<nav>
			<%@include file="include/nav.jsp" %>
		</nav>
		<section id="container">
			<form role="form" method="post" autocomplete="off">
				<p>
					<label for="bno">글 번호</label>
					<input type="text" id="bno" value="${modify.bno}" readonly="readonly" />
				</p>
				<p>
					<label for="title">글 제목</label>
					<input type="text" id="title" name="title" value="${modify.title}" />
				</p>
				<p>
					<label for="content">글 내용</label>
					<textarea name="content">${modify.content}</textarea>
				</p>
				<p>
					<label for="writer">작성자</label>
					<input type="text" id= "writer" value="${modify.writer}" readonly="readonly" /><br>
					<label>작성날짜</label>
					<span><fmt:formatDate value="${modify.regDate}" pattern="yyyy-MM-dd"></fmt:formatDate></span>
				</p>
				<p>
					<button type="submit">수정</button>
					<button type="button" id="cancel_btn">취소</button> 
					
					<script>
						//폼을 변수에 저장
						var formObj = $("form[role='form']");
						
						//취소 버튼 클릭
						$('#cancel_btn').on('click', () => {
							self.location="/board/read?bno=${modify.bno}&page=${scri.page}&perPageNum=${scri.perPageNum}&searchType=${scri.searchType}&keyword=${scri.keyword}";
						});
					</script>
				</p>
			</form>
		</section>
		<footer>
		<%@ include file="include/footer.jsp" %>
	</footer>
	</div>

</body>
</html>