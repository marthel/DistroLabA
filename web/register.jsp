<%--
  Created by IntelliJ IDEA.
  User: Marthin
  Date: 2016-09-26
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register</title>
</head>
<body>

<form method="post" action="/register">
    username: <input type="text" name="username"/><br/>
    email: <input type="text" name="email"/><br/>
    password: <input type="password" name="password"/><br/>
    <input type="submit" value="register"/>
</form>
<c:if test="${not empty error}">
    <h1 style="color:red;">${error}</h1>
</c:if>
</body>
</html>
