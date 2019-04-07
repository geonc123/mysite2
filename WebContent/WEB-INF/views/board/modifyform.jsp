<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
	<title>Mysite</title>
</head>
<body>
	<div id="container">
		<div id="header">
				<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		</div><!-- /header -->
	
		<div id="navigation">
			<ul>

				<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
			</ul>
		</div><!-- /navigation -->
		
		<div id="content">
			<div id="c_box">
				<div id="board">
					<h2>게시판-수정</h2>
					
					<form class="board-form" method="post" action="${pageContext.request.contextPath}/geust">
						<input type="hidden" name="action" value="modify">
						<input type="hidden" name="no" value="${getList.no}" >
				
						<table class="tbl-ex">
							<tr>
								<th colspan="2">글수정</th>
							</tr>
							<tr>
								<td class="label">제목</td>
								<td><input type="text" name="title" value=""></td>
							</tr>
							<tr>
								<td class="label">내용</td>
								<td>
									<textarea id="content" name="content"></textarea>
								</td>
							</tr>
						</table>
				
						<div class="bottom">
							<a href="${pageContext.request.contextPath}/geust">취소</a>
							<input type="submit" value="수정">
						</div>
					</form>	
					
				</div><!-- /board -->
			</div><!-- /c_box -->
		</div><!-- /content -->
			
			
			
		<div id="footer">
			<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div>
		</div><!-- /footer -->
	</div><!-- /container -->
</body>
</html>


