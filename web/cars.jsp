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
<body bgcolor="#465060">

<%if (session.getAttribute("role") == null) { %>
<p> access denied </p>
<% } else {%>

<c:import url="/getCars"/>

<c:set var="cars" value="${requestScope.carList}"/>

<c:forEach var="car" items="${cars}" varStatus="i">
    <div class="card">
        <img src="https://lifebysaje.files.wordpress.com/2011/03/fiat-500-by-gucci-white.jpg" alt="Avatar" style="width:100%">
        <div class="container">
            ${car.toString()}<br>
        </div>
        <form method="post" action="/addToCart" style="float: right; vertical-align: bottom;">
            <input type="hidden" name="cartItem" value="${car.getModel()}"/>
            <br>
            <input style="background-color: gray" type="submit" value="add to cart"/>
        </form>
        <%if (session.getAttribute("role").equals("customer")) { %>
        <form method="post" action="/removeCar" style="float: right; vertical-align: bottom;">
            <input type="hidden" name="carModel" value="${car.getModel()}"/>
            <input name="remove" style="background-color: gray" type="submit" value="remove " />
        </form>


        <button onclick="displayPop('${car.getModel()}')">Open Modal</button>
        <!-- The Modal -->
        <div id="${car.getModel()}" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-header">
                    <span onclick="closes('${car.getModel()}')" class="close">×</span>
                    <h2>${car.getManufacturer()}</h2>
                </div>
                <form method="post" action="/updateShop">
                    <div class="modal-body">
                        Year     : <input type="text" name="year" value="${car.getYear()}"/><br/>
                        Quantity : <input type="text" name="quantity" value="${car.getQuantity()}"/><br/>
                        Price    : <input type="text" name="price" value="${car.getPrice()}"/><br/>
                        Model    : <input type="text" name="carModel" value="${car.getModel()}"/><br/>
                        <input type="hidden" name="oldModel" value="${car.getModel()}"/>
                    </div>
                    <div class="modal-footer">
                        <button onclick="closes('${car.getModel()}')">SUBMIT</button>
                    </div>
                </form>
            </div>

        </div>

    </div>
        <% }%>

    <script>
        // Get the modal
        var modal = document.getElementById('myModal');

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal
        function displayPop(id) {
            var modal = document.getElementById(id);
            modal.style.display = "block";
        }

        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        function closes(id) {
            var modal = document.getElementById(id);
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>

</c:forEach>
<% } %>

<%if (session.getAttribute("role").equals("customer")) { %>

<% }%>

<div class="card" >
    <!-- Trigger/Open The Modal -->
    <button id="myBtn">
        <img src="http://worldartsme.com/images/add-sign-clipart-1.jpg">
    </button>

    <!-- The Modal -->
    <div id="myModal" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <form method="post" action="/addCars">
            <div class="modal-header">
                <span class="close">×</span>
                Manufacturer : <input type="text" name="add_manufacturer"/><br/>
            </div>
                <div class="modal-body">
                    Year     : <input type="text" name="add_year"/><br/>
                    Quantity : <input type="text" name="add_quantity"/><br/>
                    Price    : <input type="text" name="add_price"/><br/>
                    Model    : <input type="text" name="add_carModel"/><br/>
                    <input type="hidden" name="oldModel" value="${car.getModel()}"/>
                </div>
                <div class="modal-footer">
                    <button onclick="closes('${car.getModel()}')">SUBMIT</button>
                </div>
            </form>
        </div>

    </div>

</div>


<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

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
