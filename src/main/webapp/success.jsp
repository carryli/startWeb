<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<a>Login success !!!!</a>
<s:if test="members != null">
	<s:iterator value="members" var="member" >
		<s:property value="name" /> | <s:property value="phone" /> | <s:property value="email" />
	</s:iterator>
</s:if>
</body>
</html>