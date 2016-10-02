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
<p>HEJ </p>
<c:if test="${not empty message}">
    <p>
        ${message}
        <%= session.getAttribute("username") %>
         roll:   <%= session.getAttribute("role") %>
    </p>
</c:if>
<c:if test="${not empty user}">
            ${user.getUsername()}
</c:if>
</body>
</html>
