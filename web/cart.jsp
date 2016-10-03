<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Scalman
  Date: 03/10/16
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%if (request.getAttribute("cItems") != null) { %>
<c:set var="cars" value="${requestScope.cItems}"/>
<c:forEach var="car" items="${cars}" varStatus="i">
    ${car.toString()}<br>
</c:forEach>
<form method="post" action="/createOrder">
    first name: <input type="text" name="firstName"/><br/>
    last name: <input type="text" name="lastName"/><br/>
    phone: <input type="text" name="phone"/><br/>
    address: <input type="text" name="address"/><br/>
    <input type="submit" value="order"/>
</form>
<% }%>

<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
</body>
</html>
