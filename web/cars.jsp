<%--
  Created by IntelliJ IDEA.
  User: Marthin
  Date: 2016-09-26
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/getCars" />

<c:set var="cars" value="${requestScope.carList}" />
<p>
    <%= session.getAttribute("username") %>
    roll:   <%= session.getAttribute("role") %>
</p>
<h1>List of Cars</h1>
<c:forEach var="car" items= "${cars}" varStatus="i">
    ${car.toString()}<br>
</c:forEach>
<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
</body>
</html>
