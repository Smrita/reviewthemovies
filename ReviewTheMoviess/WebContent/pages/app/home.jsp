<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@page import="auth.model.dto.User" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! User user=new User(); %>
Welcome this is home
<form action="index" method="get">
   
   <input type="hidden" name="logout" value="true">
<!-- //        HttpSession ses=request.getSession(false); -->
<!-- //        ses.setAttribute("logout", "true"); -->

<!-- //       HttpSession ses=request.getSession(false); -->
<!-- //     		  ses.invalidate(); -->
   
   
<input type="submit" value="logout" name="logout">  
</form>

</body>
</html>