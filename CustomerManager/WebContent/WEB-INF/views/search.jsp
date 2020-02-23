<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Customer Manager</title>
</head>
<body>

<div align="center">
    <h1> Search Results </h1>
    <table border="1" padding="5">
       <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Address</th>
       </tr>
       <c:forEach items="${result}" var="customer">
          <tr>
             <td>${customer.id}</td>
             <td>${customer.name}</td>
             <td>${customer.email}</td>
             <td>${customer.address}</td>
          </tr>
       </c:forEach>
    </table>
</div>
</body>
</html>