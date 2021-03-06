<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

    <c:set var = "personname" value = "${person.name}"/>
<c:set var = "name" value = "${user.name}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>




<h1>Hi, ${personname}</h1>
<div>
<!--
<a href="${contextPath}/user/register" >register here</a> <br/>-->
<a href="${contextPath}/person/register" >Person register here</a> <br/>
<%--<c:if test = "${name == null}">
    <a href="${contextPath}/user/login" >login here</a> <br/>
</c:if>--%>
    <c:if test = "${personname == null}">
    <a href="${contextPath}/person/login" > Person login here</a> <br/>
</c:if>

<%--<c:if test = "${name != null}">
    <a href="${contextPath}/user/logout" >logout now</a> <br/>
</c:if>--%>
    <c:if test = "${personname != null}">
    <a href="${contextPath}/person/logout" >logout now</a> <br/>
</c:if>
     <a href="${contextPath}/flight/list" >View Flights</a> <br />

<!--<a href="${contextPath}/category/add" >Add Category</a> <br />

<a href="${contextPath}/advert/add" >Add Advertisement</a> <br />
<a href="${contextPath}/advert/list" >View All Advertisements</a> <br />-->
</div>
 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>