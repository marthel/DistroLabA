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

        <form action="/AuthenticationServlet">
        <br>
        <h1 class="text-in-drop-down">
            Username
        </h1>
        <input name="usr-name" type="text" class="text-box-drop-down" align="center">
        <br>
        <h1 class="text-in-drop-down">
            Password
        </h1>
        <input name="password" type="password" class="text-box-drop-down" align="center">
        <br>
        <h1 class="text-in-drop-down">
            Confirm password
        </h1>
        <input name="confirm-password" type="password" class="text-box-drop-down" align="center">
        <br>
        <br>
        <br>
        <div class="wrapper">
            <button class="submit">Submit</button>
        </div>
        <h1 class="Welcome">
            WELCOME
        </h1>
        </form>
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
    </div>

</div>



<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="home_animation.js">

</script>
</body>
</html>

