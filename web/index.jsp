<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Marthin
  Date: 2016-09-26
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/menu_buttons.css">

</head>
<body>
<!--Animation Page Move Up and Down -->
<div class="slide-down-page">
    <a href="#" class="right-buttons-drop-down" id="close">Close</a>
    <div class="text-align-pos">

        <form action="/login" method="post">
        <br>
        <h1 class="text-in-drop-down">
            Username
        </h1>
        <input name="username" type="text" class="text-box-drop-down" align="center">
        <br>
        <h1 class="text-in-drop-down">
            Password
        </h1>
        <input name="password" type="password" class="text-box-drop-down" align="center">
        <br>
        <br>
        <div class="wrapper">
            <input class="submit" type="submit" value="Login"/>
            <!--<button class="submit">Submit</button>-->
        </div>
        <h1 class="Welcome">
            WELCOME
        </h1>
        </form>
        <c:if test="${not empty message}">
            <h1>${message}</h1>
        </c:if>
    </div>
</div>


<div class="content">
    <!--Menu Bar-->

    <%@include file="carshopHeader.html" %>
    <!--Video-->
    <div class="background-wrap">
        <video  id="video-bg-content"  preload="auto" autoplay="autoplay" loop="loop" src="background.mp4">
            Video Not Supported By Your Browser.
        </video>
        <img src="http://pictures.topspeed.com/IMG/crop/201211/2014-mercedes-sls-amg-bla-19_1600x0w.jpg"/>
        <div>
            <button class="facebook-twitter-instagram"></button>
            <button class="facebook-twitter-instagram"></button>
            <button class="facebook-twitter-instagram"></button>
        </div>
    </div>

</div>


<iframe width="0" height="0" src="http://www.youtube.com/embed/FoBMoI62WFs?rel=0&autoplay=1"
        frameborder="0" allowfullscreen></iframe>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="home_animation.js">

</script>
</body>
</html>



