<%--
  Created by IntelliJ IDEA.
  User: ThucPug
  Date: 10/7/2019
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form update user</h1>
<c:url value="/update-person" var="url"></c:url>
<form:form modelAttribute="person" method="post" action="${url}">
    <form:hidden path="id"></form:hidden>
    Name: <form:input path="name"  Value ="${person.name}" />
    <br/>
    <p>Gender</p>
    <form:select path="gender" ValueDefault="${person.gender}">
        <form:option value="Nam">Nam</form:option>
        <form:option value="Nu">Nu</form:option>
    </form:select>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>