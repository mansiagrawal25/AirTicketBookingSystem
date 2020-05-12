<%-- 
    Document   : viewCart
    Created on : Dec 12, 2019, 3:08:02 PM
    Author     : mansiagrawal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <h1>Hello ${person.name}</h1>
        	<a href="${contextPath}/user/">Home</a><br/>
         <c:set var = "cart" value = "${cart}"/>
         <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
          
            <c:if test="${cart !=null}">
                <h3>Your cart contents</h3>
      
         <table border="1">
                    <tr>
                        <th>Flight Number</th>
		                <th>Flight Name</th>
		                <th>Airplane Id</th>
		                <th>Price</th>
		                <th>Departure time</th>
		                <th>Destination arrival time </th>
                    </tr>
                    <c:forEach var="flight" items="${sessionScope.cart}">
                <tr>
                    <td>${flight.flight_id}</td>
                    <td>${flight.flight_name}</td>
                    <td>${flight.airplane_id}</td>
                    <td>$${flight.amount}</td>
                    <td>${flight.deptTime}</td>
                    <td>${flight.arrivalTime}</td>
                    <td><a href="removeFromCart.htm?action=remove&id=${flight.flight_id}"> [Remove from cart]</a></td>
                </tr>   
            </c:forEach>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td>Total</td>
                        <td>${sessionScope.total}</td>
                    </tr>
                     <a href="${contextPath}/passenger/passenger1.htm"> Proceed to enter details and Payment>></a>
                </table>
                    </c:if>
         <c:if test="${cart ==null}">
                <h3>Oops.. your cart is empty</h3>
                <p><a href="userHome">Return to main page</a></p>
           </c:if>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
