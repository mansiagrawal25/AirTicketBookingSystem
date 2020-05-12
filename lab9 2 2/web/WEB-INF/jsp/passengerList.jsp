<%-- 
    Document   : passengerList
    Created on : Dec 13, 2019, 2:44:07 AM
    Author     : mansiagrawal
--%>
<%@page import="com.me.pojo.Ticket"%>
<%@page import="java.util.List"%>
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
          <c:set var = "name" value = "${person.name}"/>
          ${name}
          ${ticketList}
                 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
      <h3> Below are the passengers details</h3>

      <table border="1">
		<thead>
                    
			<tr>
                            <th>S.No</th>
                            <th>Passenger Name</th>
	<th>Passenger Email</th>
	<th>Flight Name</th>
	<th>Travelling From</th>
	<th>Destination</th>
	<th>Date of travel</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
				List<Ticket> list = (List) request.getAttribute("ticketList");
			%>
 
			<%
				for (Ticket u : list) {
			%>
			<tr>
				<td><%=i++%></td>
                                <td><%=u.getPassengerDetails().getFirstName()%></td>
                                <td><%=u.getPassengerDetails().getEmail()%></td>
                                
				<td><%=u.getFlightDetails().getFlight_name()%></td>
                                <td><%=u.getFlightDetails().getFrom()%></td>
                                <td><%=u.getFlightDetails().getDest()%></td>
                                <td><%=u.getFlightDetails().getDeptDate()%></td>
				
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
<h3><a href="${contextPath}/person/login/adminHome">Go Back to Menu Page</a></h3>
    </body>
</html>
