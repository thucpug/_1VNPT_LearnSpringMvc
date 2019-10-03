<%--
  Created by IntelliJ IDEA.
  User: ThucPug
  Date: 10/3/2019
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resource/js/main.js"/>'></script>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form add user</h1>
<c:url value="/adduser" var="url"></c:url>
<form:form modelAttribute="person" method="post" action="${url}">
    Name: <form:input path="name"/>
    <p style="background-color:red;"><form:errors path="name"></form:errors></p>
    <br/>
    Age: <form:input path="age"/>
    <p style="background-color:red;"><form:errors path="age"></form:errors></p>
    <p> Favorite:</p>
    <input:checkbox path="listFavorite" value="xemphim" label="Xem phim"/>
    <input:checkbox path="listFavorite" value="dabong" label="dabong"/>
    <input:checkbox path="listFavorite" value="chaybo" label="Chay bo"/>
    <p>Gender</p>
    <form:select path="gender">
        <form:option value="Nam">Nam</form:option>
        <form:option value="Nu">Nu</form:option>
    </form:select>
    <input type="submit" value="Submit"/>
</form:form>
<img src="<c:url value="/resource/image/3.jpg" />" width="100%">
</body>
</html>
