<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../includes/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="movie" items="${movieList}">
		${movie._releaseDate}<br>
		${movie._pgRating}<br>
		${movie._length}<br>
		${movie._summary}<br>
		<c:forEach var="actor" items="${movie._stars}">
			${actor}<br/>
		</c:forEach>
		<c:forEach var="director" items="${movie._directors}">
			${director}<br/>
		</c:forEach>
		
		<c:forEach var="writer" items="${movie._writers}">
			${writer}<br/>
		</c:forEach>
		
		${movie._imageLink }<br/>
		
		
	</c:forEach> 


</body>
</html>