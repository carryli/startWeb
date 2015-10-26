<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserBook Page</title>
</head>
<body>
<p>************add borrow********* </p>
<form action="userbook/add" modelAttribute="userBook" method="post">
   userId <input type = "text" name = "userId" />
   bookId <input type = "text" name = "bookId" /><br />
   <input type = "submit" value = "addBorrow"/><br/>
</form>
<br/>
<p>*************add book********* </p>
<form action="book/add" modelAttribute="book" method="post">
   bookName <input type = "text" name = "bookName" />
   author <input type = "text" name = "author" />
   address <input type = "text" name = "location" /><br />
   <input type = "submit" value = "addBook"/><br/>
</form>
<br/>
<p>************add user************ </p>
<form action="sava.html" modelAttribute="user" method="post">
    username<input type = "text" name = "username" />
    password<input type = "text" name = "password" />
    roleId<input type = "text" name = "roleId" />
    maxDay<input type = "text" name = "maxday" />
    dayCost<input type = "text" name = "daycost" /><br />
    <input type = "submit" value = "addUser"/><br/>
</form>
<p>*************find*************** </p>
<form action="userbook/find">
	<input type = "text" name = "recordId"/><br/>
	<input type = "submit" value = "find"/>
</form>
</body>
</html>