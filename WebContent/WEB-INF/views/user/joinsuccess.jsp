<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
	<title>Mysite</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>MySite</h1>
			<ul>
				<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
			</ul>
		</div><!-- /header -->
	
		<div id="navigation">
			<ul>
				<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
			</ul>
		</div><!-- /navigation -->
		
		<div id="content">
			<div id="c_box">
				<div id="user">
					<h2>회원가입성공</h2>
					
					<p class="form-box">
						회원가입을 축하합니다.
						<br><br>
						<a href="${pageContext.request.contextPath}/user?action=loginform">로그인하기</a>
					</p>
					
				</div><!-- /user -->
			</div><!-- /c_box -->
		</div><!-- /content -->
			
			
			
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div><!-- /footer -->
	</div><!-- /container -->
</body>
</html>
