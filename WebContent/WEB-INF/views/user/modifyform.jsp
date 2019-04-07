<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet"
	type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet"
	type="text/css">
<title>Mysite</title>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<div id="navigation">
			<ul>
				<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
			</ul>
		</div>
		<!-- /navigation -->

		<div id="content">
			<div id="c_box">
				<div id="user">
					<h2>회원정보 수정</h2>

					<form class="form-box" method="post" action="${pageContext.request.contextPath}/user">
						<input type="hidden" name="action" value="modify">

						<div class="form-group">
							<label class="block-label" for="name">이름</label> <input id="name"
								type="text" name="name" value="">
						</div>

						<div class="form-group">
							<label class="block-label" for="email">이메일</label>
							<p>
								<strong>
									aaa@aaaaa.aaa
								</strong>
							</p>
						</div>
						<div class="form-group">
							<label class="block-label" for="password">패스워드</label> <input
								id="password" type="password" name="password" value="">
						</div>
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female">
							<label>남</label> <input type="radio" name="gender" value="male"
								checked="checked">
						</fieldset>

						<input type="submit" value="수정완료">

					</form>

				</div>
				<!-- /user -->
			</div>
			<!-- /c_box -->
		</div>
		<!-- /content -->



		<div id="footer">
				<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div>
		<!-- /footer -->
	</div>
	<!-- /container -->
</body>
</html>

