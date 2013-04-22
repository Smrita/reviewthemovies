<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:if test="${signUpError}!=null">
      ${signUpError}
    </c:if>  
<form action="signup" name="signup" method="post">    
<p>FirstName:<input type="text" name="firstName"></p>
<p>MiddleName:<input type="text" name="middleName"></p>
<p>LastName<input type="text" name="lastName"></p>
<p>Email<input type="text" name="email"></p>
<p>Password<input type="password" name="password"></p>
<p>Country<input type="text" name="country"></p>
<input type="submit" name="submit" value="SignUp"/>
</form>
</body>
</html>