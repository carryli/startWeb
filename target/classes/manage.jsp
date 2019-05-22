<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<%-- <% org.carryli.work.entity.UserBook record = (org.carryli.work.entity.UserBook)request.getAttribute("record"); %> 
 --%></head>
<body>
<c:if test="${userBook!=null}">
<%-- <p>recordId   <%=record.getRecordId() %></p>
<p>userId     <%=record.getUserId()%></p>
<p>bookId     <%=record.getBookId()%></p>
<p>borrowDate <%=record.getBorrowDate()%></p> --%>
<p>recordId   ${userBook.recordId}</p>
<p>userId     ${userBook.userId}</p>
<p>bookId     ${userBook.bookId}</p>
<p>borrowDate ${userBook.borrowDate}</p>
</c:if>
<form action="userbook/delete">

	<p>UserBook List</p>
	<c:forEach items="${books}" var="guest">
		<li><li>
			<li>${guest.recoreId}</li>
			<li>${guest.bookId}</li>
			<li>${guest.userId}</li>
			<li>${guest.borrowDate}</li>	
    <input type = "submit" value = "delete" />
		</li></li>
	</c:forEach>
</form>
</body>
</html>