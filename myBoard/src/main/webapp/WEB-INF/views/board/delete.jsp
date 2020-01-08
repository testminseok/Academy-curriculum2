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
					<input type="text" id="bno" value="${delete}" readonly="readonly" />
				</p>
				<p>
					정말로 삭제하시겠습니까 ? 
				</p>
				<p>
					<button type="submit">예, 삭제합니다</button>
					<button type="button" id="cancel_btn">취소</button> 
					<script>
						//폼을 변수에 저장
						var formObj = $("form[role='form']");
						
						//취소 버튼 클릭
						$('#cancel_btn').on('click', () => {
							self.location="/board/read?bno=${delete}&page=${scri.page}&perPageNum=${scri.perPageNum}&searchType=${scri.searchType}&keyword=${scri.keyword}";
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