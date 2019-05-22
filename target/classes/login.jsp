<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form action="login.html"  modelAttribute="user" method="post">
    Username:
    <input type = "text" name = "username" /><br />
    Password:
    <input type = "text" name = "password" /><br>
    <input type = "submit" value = "Login" />
</form>
<form action="register.action" modelAttribute="member" method="post">
    name:
    <input type = "text" name = "name" /><br />
    phone:
    <input type = "text" name = "phone" /><br>
    email
    <input type = "text" name = "email" /><br>
    <input type = "submit" value = "Submit" />
</form>

<form action="hellog">
    name:
    <input type = "text" name = "name" /><br />
    phone:
    <input type = "text" name = "phone" /><br>
    email
    <input type = "text" name = "email" /><br>
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>