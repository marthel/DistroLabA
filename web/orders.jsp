<%--
  Created by IntelliJ IDEA.
  User: Marthin & Scalman
  Date: 2016-09-26
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="carshopHeader.html" %>


<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="./css/cars.css">
</head>
<body bgcolor="#dcdcdc">

<%if (!session.getAttribute("role").equals("employee")) { %>
<p> access denied </p>
<% } else {%>

<c:import url="/getOrders"/>

<c:set var="orders" value="${requestScope.orderList}"/>
<p>
    <%= session.getAttribute("username") %>
    roll:   <%= session.getAttribute("role") %>
</p>

<c:forEach var="order" items="${orders}" varStatus="i">
        ${order.toString()}
        <form method="post" action="/sendOrder">
            <input type="hidden" name="orderID" value="${order.getID()}"/>
            <input type="submit" value="send order"/>
        </form>
    </br>
</c:forEach>
<% } %>
<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
</body>
</html>
