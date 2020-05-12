<%-- 
    Document   : updateFlight
    Created on : Dec 12, 2019, 12:10:00 AM
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

    </head>
    <body>
        <h1>Hello World!</h1>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
 
<form:form action="updateFlight.htm" commandName="flight" method="post">
<table>
<tr>
<td>Flight ID</td>
<td><form:input type="text" path="flight_id" value="${requestScope.flight.flight_id}" size="30"/><font color="red"><form:errors path="flight_name"/></font></td>
</tr>
<tr>
<td>Flight Name</td>
<td><form:input type="text" path="flight_name" value="${requestScope.flight.flight_name}" size="30"/><font color="red"><form:errors path="flight_name"/></font></td>
</tr>
<tr>
<td>Airplane Id</td>
<td><form:input type="text" path="airplane_id" value="${requestScope.flight.airplane_id}" size="30"/><font color="red"><form:errors path="airplane_id"/></font></td>
</tr>
<tr>
<td>From</td>
<td><form:input type="text" path="from" value="${requestScope.flight.from}" size="30"/><font color="red"><form:errors path="from"/></font></td>
</tr>
<tr>
<td>Dest</td>
<td><form:input type="text" path="dest" value="${requestScope.flight.dest}" size="30"/><font color="red"><form:errors path="dest"/></font></td>
</tr>
<tr>
<td>Departure Time</td>
<td><form:input type="text" path="deptTime" value="${requestScope.flight.deptTime}" size="30"/><font color="red"><form:errors path="deptTime"/></font></td>
</tr>
<tr>
<td>Arrival Time</td>
<td><form:input type="text" path="arrivalTime" value="${requestScope.flight.arrivalTime}" size="30"/><font color="red"><form:errors path="arrivalTime"/></font></td>
</tr>
<tr>
<td>Travel Class</td>
<td><form:input type="text" path="travelClass" value="${requestScope.flight.travelClass}" size="30"/><font color="red"><form:errors path="travelClass"/></font></td>
</tr>
<tr>
<td>Total Seats</td>
<td><form:input type="text" path="totalSeats" value="${requestScope.flight.totalSeats}" size="30" readonly="true"/><font color="red"><form:errors path="totalSeats"/></font></td>
</tr>
<tr>
<td>Available Seats</td>
<td><form:input type="text" path="availableSeats" value="${requestScope.flight.availableSeats}" size="30"/><font color="red"><form:errors path="availableSeats"/></font></td>
</tr>
<tr>
<td>Amount</td>
<td><form:input type="text" path="amount" value="${requestScope.flight.amount}" size="30"/><font color="red"><form:errors path="amount"/></font></td>
</tr>
<tr>
<td>Departure Date</td>
<td><form:input type="text" path="deptDate" id="txtFromDate" value="${requestScope.flight.deptDate}" size="30"/><font color="red"><form:errors path="deptDate"/></font></td>
</tr>
<tr>
<td>Arrival Date</td>
<td><form:input type="text" path="arrDate" id="txtToDate" value="${requestScope.flight.arrDate}" size="30"/><font color="red"><form:errors path="arrDate"/></font></td>

</tr>

<tr>
    <td colspan="2"><input type="submit" value="Update flight to database" /></td>
</tr>

</table>



</form:form>
<a href="adminHome.htm">Go Back to Menu Page</a>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
