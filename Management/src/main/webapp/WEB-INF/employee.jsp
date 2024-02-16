<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrations of employee</title>
</head>
<body>
<form action="RegistrationController"  method="post">
<div><lable for="name"> Firstname </lable><input type="text" name="fname" id="fname"></div>
<div><lable for="name"> Lastname </lable><input type="text" name="lname" id="lname"></div>
<div><lable for="name"> Email </lable><input type="text" name="email" id="email"></div>
<div><lable for="name"> Position </lable><input type="text" name="position" id="position"></div>
<div><lable for="name"> Mobile </lable><input type="text" name="mobile" id="mobile"></div>
<input type="submit" value="Register">
</form> 
<h2>Registered Employee</h2>
<table>
<tr>
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Position</th>
<th>Mobile</th>
</tr>
<c:forEach var="employee" items="${employees}">
<tr>
<td><c:out value="${employee.id }" /></td>
<td><c:out value="${employee.firstName }" /></td>
<td><c:out value="${employee.lastName }" /></td>
<td><c:out value="${employee.email }" /></td>
<td><c:out value="${employee.position }" /></td>
<td><c:out value="${employee.mobile }" /></td>
</tr>

</c:forEach>
</table>

</body>
</html>