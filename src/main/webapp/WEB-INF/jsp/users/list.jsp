<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="../welcome.jsp"></jsp:include>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ usersList }" var="user">
						<tr>
							<td>${ user.id }</td>
							<td>${ user.firstName }</td>
							<td>${ user.lastName }</td>
							<td>${ user.email }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</body>
</html>