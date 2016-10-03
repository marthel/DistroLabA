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

<%if (request.getAttribute("seeItems") != null) { %>
<c:set var="seeItems" value="${requestScope.seeItems}"/>

<c:forEach var="car" items="${seeItems}" varStatus="i">
    ${car.toString()}<br>
</c:forEach>
<% }%>

<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
</body>
</html>
