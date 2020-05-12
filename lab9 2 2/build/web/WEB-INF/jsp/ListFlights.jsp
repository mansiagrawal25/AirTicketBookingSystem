<%-- 
    Document   : ListFlights
    Created on : Dec 11, 2019, 10:17:16 PM
    Author     : mansiagrawal
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script> var $rows = $('#table tr');
$('#search').keyup(function() {
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
    
    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});</script>
    </head>
    
    
    <body>
        <h1>View Flights</h1>
            <c:set var = "name" value = "${person.name}"/>
               <h1>Hi, ${name}</h1>

              
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <c:set var = "personname" value = "${flight}"/>

    <input type="text" id="search" placeholder="Type to search">

         <form action="${contextPath}/flight/update" method="get">
<table id="table"border="1">

<tr>
					<th>Flight Name </th>
					<th>Airplane Id</th>
					<th>From</th>
					<th>Dest</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Travel Class</th>
					<th>Total Seats</th>
					<th>Amount</th>
					<th>Departure Date</th>
					<th>Arrival Date</th>
</tr>

<c:forEach var="flight" items="${flight}">
<tr>
					<td>${flight.flight_name}</td>
                    <td>${flight.airplane_id}</td>
                    <td>${flight.from}</td>
                    <td>${flight.dest}</td>
                    <td>${flight.deptTime}</td>
                    <td>${flight.arrivalTime}</td>
                    <td>${flight.travelClass}</td>
                    <td>${flight.totalSeats}</td>
                    <td>${flight.amount}</td>
                    <td>${flight.deptDate}</td>
                    <td>${flight.arrDate}</td>
                    <td>${flight.availableSeats}</td>
                    <c:if test = "${person.role == 'admin'}">
                         <td><a href="updateFlights.htm?id=${flight.flight_id}&action=update">Update Flight</a></td>
                    <td><a href="deleteFlights.htm?id=${flight.flight_id}">Delete Flight</a></td>
                    </c:if>
                    <c:if test = "${person.role == 'customer'}">
                        <td><a href="addToCart.htm?fid=${flight.flight_id}"  id="link">Book Ticket</a></td> 
                    </c:if>
                   
</tr>
</c:forEach>
</table>
</form>
          <a class="nav-link" href="${contextPath}/flight/pagination?bunchsize=${requestScope.flight.size()}" >Next Page</a>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


    </body>
</html>
