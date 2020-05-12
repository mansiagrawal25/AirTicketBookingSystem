<%-- 
    Document   : userHome
    Created on : Dec 10, 2019, 9:20:32 PM
    Author     : mansiagrawal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <h1>User Home </h1>
        
                    <c:set var = "personname" value = "${person.name}"/> 
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>Hi, ${personname}</h1>
        

        
       <c:if test = "${personname == null}">
    <a href="${contextPath}/person/login" > Person login here</a> <br/>
</c:if>
    <c:if test = "${personname != null}">
    <a href="${contextPath}/person/logout" >logout now</a> <br/>
</c:if>
    
      <a href="${contextPath}/flight/list" >View Flights</a> <br />
<%--<form:form action="${contextPath}/flight/search" commandName="flight" method="post">
<table>

<tr>
<td>From</td>
<td><form:input type="text" path="from" size="30"/><font color="red"><form:errors path="from"/></font></td>
</tr>
<tr>
<td>Dest</td>
<td><form:input type="text" path="dest" size="30"/><font color="red"><form:errors path="dest"/></font></td>
</tr>

<tr>
<td>Travel Class</td>
<td><form:input type="text" path="travelClass" size="30"/><font color="red"><form:errors path="travelClass"/></font></td>
</tr>
<tr>

<td>Departure Date</td>
<td><form:input type="text" path="deptDate" id="txtFromDate" size="30"/><font color="red"><form:errors path="deptDate"/></font></td>
</tr>


<tr>
    <td colspan="2"><input type="submit" value="Search flights" /></td>
</tr>
</table>
</form:form>--%>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
