<%--
  Created by IntelliJ IDEA.
  User: Marthin
  Date: 2016-09-26
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include  file="carshopHeader.html" %>
</head>
<body>
<form method="post" action="login.jsp">
    <table border="1">
        <tr>
            <td>User Name:</td>
            <td><input type="text" name="uname" value=""
            /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="pass" value=""
        <tr>
            <td><input type="submit" value="Login"
            /></td>
        </tr>
    </table>
</form>

</body>
</html>
