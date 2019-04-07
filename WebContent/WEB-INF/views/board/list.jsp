<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/mysite.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
<title>Mysite</title>
</head>
<body>
	<div id="container">
		<div id="header">

			<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		</div>
		<!-- /header -->

		<div id="navigation">
			<ul>

				<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
			</ul>
		</div>
		<!-- /navigation -->

		<div id="content">
			<div id="c_box">
				<div id="board">
					<h2>게시판-리스트</h2>

					<form action="" method="post">
						<input type="text" id="kwd" name="kwd" value=""> <input
							type="submit" value="찾기">
					</form>

					<table class="tbl-ex">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>조회수</th>
							<th>작성일</th>
							<th>&nbsp;</th>
						</tr>
						<c:forEach items="${geustList}" var="vo" varStatus="status">
							<tr>
								<td>${vo.no }</td>
								<td><a href="${pageContext.request.contextPath}/geust?action=read&no=${vo.no}">${vo.title}</a></td>
								<td>${vo.name}</td>
								<td>${vo.hit }</td>
								<td>${vo.reg_date}</td>
								<c:if test="${vo.user_no == seeeionScope.authUser.no }">
								<td><a href="${pageContext.request.contextPath}/geust?action=delete&no=${vo.no}" class="del">삭제</a></td>
								</c:if>
							</tr>
						</c:forEach>

					</table>


					<div class="pager">
						<ul>
							<li><a href="">◀</a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li class="selected">3</li>
							<li><a href="">4</a></li>
							<li><a href="">5</a></li>
							<li><a href="">6</a></li>
							<li><a href="">7</a></li>
							<li><a href="">8</a></li>
							<li><a href="">9</a></li>
							<li><a href="">10</a></li>
							<li><a href="">▶</a></li>
						</ul>
					</div>
					<div class="bottom">
						<c:if test="${sessionScope.authUser != null }">
							<a
								href="${pageContext.request.contextPath}/geust?action=writeform"
								id="new-book">글쓰기</a>
						</c:if>
					</div>

				</div>
				<!-- /board -->
			</div>
			<!-- /c_box -->
		</div>
		<!-- /content -->



		<div id="footer">
			<div id="footer">
				<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
			</div>
		</div>
		<!-- /footer -->
	</div>
	<!-- /container -->
</body>
</html>

