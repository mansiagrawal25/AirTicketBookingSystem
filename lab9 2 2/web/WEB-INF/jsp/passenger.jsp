<%-- 
    Document   : passenger
    Created on : Dec 12, 2019, 5:04:35 PM
    Author     : mansiagrawal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

         <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
         <script>
	   		$(function(){
	   	    $("#dob").datepicker({
	   	        numberOfMonths: 2, 
	   	        maxDate:'0'
	   	})
	   		});

	   		function validateEmail(email) {
	   		  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	   		  return re.test(email);
	   		}

	   		function validate() {
	   		  $("#result").text("");
	   		  var email = $("#email").val();
	   		  if (validateEmail(email)) {
	   		    $("#result").text(email + " is valid :)");
	   		    $("#result").css("color", "green");
	   		  } else {
	   		    $("#result").text(email + " is not valid :(");
	   		    $("#result").css("color", "red");
	   		  }
	   		  return false;
	   		}

	   		$("form").bind("submit", validate);
	   		
	   		
	   		
	   </script>
    </head>
    <body>
          Hi, ${person.name}
      
  <h1>Please enter all details correctly</h1>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  
<form:form action="${contextPath}/passenger/passenger.htm" commandName="passenger" method="post">
<table>
<c:forTokens items="i" delims="${sessionScope.noOfTravellers}">
<tr>
    <td>First Name:</td>
    <td><form:input type="text" path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>
<tr>
    <td>Last Name:</td>
    <td><form:input type="text" path="lastName" size="30"/> <font color="red"><form:errors path="lastName"/></font></td>
</tr>
<tr>
    <td>Gender</td>
    <td><form:radiobutton value="M" path="gender" checked="checked"/>Male
    	<form:radiobutton value="F" path="gender" />Female
     </td>
</tr>
<tr>
    <td>Email:</td>
    <td><form:input type="text" path="email" id='email' size="30"/> <font color="red"><form:errors path="email"/></font></td>
</tr>
<tr>
    <td>Date of Birth:</td>
    <td><form:input type="text" path="dob" id="dob" size="30"/> <font color="red"><form:errors path="dob"/></font></td>
</tr>
<tr>
    <td>Phone Number:</td>
    <td><form:input type="text" path="phonenum" size="30" /> <font color="red"><form:errors path="phonenum"/></font></td>
</tr>
<tr>
    <td>Address:</td>
    <td><form:input type="textarea" path="address" size="30"/> <font color="red"><form:errors path="address"/></font></td>
</tr>
</c:forTokens>
<tr>
    <td colspan="2"><input type="submit" value="Save Details and Enter payment details" /></td>
</tr>
</table>
</form:form>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    </body>
</html>
