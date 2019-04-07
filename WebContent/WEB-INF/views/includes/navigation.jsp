<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/main">황일영</a></li>
		<li><a href="${pageContext.request.contextPath}/gestbook?action=list">방명록</a></li>
		<li><a href="${pageContext.request.contextPath}/geust?action=list">게시판</a></li>
	</ul>
</body>
</html>