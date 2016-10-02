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




<%if (session.getAttribute("role") == null) { %>
<p> access denied </p>
<% } else {%>
<c:import url="/getCars"/>

<c:set var="cars" value="${requestScope.carList}"/>
<p>
    <%= session.getAttribute("username") %>
    roll:   <%= session.getAttribute("role") %>
</p>
<h1>List of Cars</h1>
<c:forEach var="car" items="${cars}" varStatus="i">
    <div class="card">
        <img src="https://lifebysaje.files.wordpress.com/2011/03/fiat-500-by-gucci-white.jpg" alt="Avatar" style="width:100%">
        <div class="container">
            ${car.toString()}<br>
        </div>
        <form method="post" action="/addToCart" style="float: right; vertical-align: bottom;">
            <input type="hidden" name="cartItem" value=${car.getModel()}/>
            <input type="submit" value="add to cart"/>
        </form>
    </div>
</c:forEach>
<% } %>

<%if (session.getAttribute("cartItems") != null) { %>
<c:set var="cItems" value="${sessionScope.cartItems}"/>
<h1>Cart Items</h1>
<c:forEach var="cItem" items="${cItems}" varStatus="i">
    ${cItem}<br>
</c:forEach>
<% } %>
<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
</body>
</html>
