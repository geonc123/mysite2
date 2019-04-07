<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/mywebproject4/assets/css/mysite.css" rel="stylesheet"
	type="text/css">
<link href="/mywebproject4/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
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
				<div id="guestbook">
					<h2>방명록</h2>

					<table border="1" width="510">
						<tr>
							<td>이름</td>
							<td>
								<form method="post" action="./gestbook">
									<input type="hidden" name="action" value="insert"> <input
										type="text" name="id" value="">
							</td>
							<td>비밀번호</td>
							<td><input type="password" name="pd" value=""></td>
						</tr>
						<tr height="150">
							<td colspan="4"><textarea rows="10" cols="70" name="ta"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="3"></td>
							<td><input type="submit" value="확인"></td>
							</form>
						</tr>
					</table>
					<br>

					<c:forEach items="${emailList}" var="vo" varStatus="status">
						<table border="1" width="510">
							<tr>
								<td>${vo.no}</td>
								<td>${vo.id}</td>
								<td>${vo.nowdate}</td>
								<td>
									<form method="post" action="./gestbook">
										<input type="hidden" name="action" value="deform"> <input
											type="hidden" name="no" value= ${vo.no} > <input
											type="submit" value="삭제">
									</form>
								</td>
							</tr>
							<tr>
								<td colspan="4">${vo.noticBoard}</td>
							</tr>
						</table>
						<br>
					</c:forEach>
					<br>
				</div>
				<!-- /guestbook -->
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

