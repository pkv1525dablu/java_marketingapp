<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Leads</title>
</head>
<body>
	<h2>Create new Lead-1</h2>
	<table border='1'>

		<tr>
			<th>FirstName</th>
			<th>lastName</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
   <c:forEach var="lead" items="${leads}"> 
    <tr>
			<td>${lead.firstName}</td>
			<td>${lead.lastName}</td>
			<td>${lead.email}</td>
			<td>${lead.mobile}</td>
			<td> <a href="delete?id=${lead.id}">delete</a>    </td>
			<td> <a href="update?id=${lead.id}">update</a>    </td>
			
		</tr>
   </c:forEach>
         
	</table>
</body>
</html>