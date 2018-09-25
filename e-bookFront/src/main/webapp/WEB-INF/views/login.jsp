<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login Page</title>
<link href="<c:url value='/resources/css/aboutus.css'></c:url>" rel="stylesheet">
<link href="<c:url value='/resources/css/login.css'></c:url>" rel="stylesheet">

</head>
<body>

<span style="color:red">${error }</span><br>
${msg }<br>

<c:url value="/j_spring_security_check" var="url"></c:url>
<form  style="max-width:500px;margin:auto" method="post" action="${url }">
<h2><b>Login Page</b></h2>
<div class="input-container">
    <i class="fa fa-envelope icon"></i>
   <input class="input-field" type="text" placeholder="Email" name="j_username"><br>
</div>

<div class="input-container">
    <i class="fa fa-key icon"></i>
<input class="input-field" type="password" placeholder="Password" name="j_password">
  </div>

<button type="submit" class="btn">Login</button> 

</form>
</body>
</html>