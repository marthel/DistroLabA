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
<c:out value="${pageContext.session.id}"/>
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
            ${car.toString()}
            <button onclick="addToCart()" value=${car.getModel()}>Buy</button>
        </div>
    </div>
</c:forEach>
<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
<% } %>
</body>
</html>
