<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<!--form action="login">
    Username:
    <input type = "text" name = "username" /><br />
    Password:
    <input type = "password" name = "password" /><br>
    <input type = "submit" value = "Login" />
</form-->
<p>Login success !!!!</p>
<c:if test="${users != null }">
	<p>User List</p>
	<c:forEach var="user" items="${users}" >
		<li>${user.username} 
		 ${user.daycost} 
		  ${user.maxday}</li>
	</c:forEach>
</c:if>
</body>
</html>