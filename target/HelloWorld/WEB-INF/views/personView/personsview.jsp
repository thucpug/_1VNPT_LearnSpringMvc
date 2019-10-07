<%--
  Created by IntelliJ IDEA.
  User: ThucPug
  Date: 10/7/2019
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
</head>
<body>
<h1>Danh sach nguoi dung</h1>
<a href="<c:url value="/add-person/${person.id}" />">Add</a>
<hr>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Gioi tinh</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.gender}</td>
            <td><a href="<c:url value="/detail-person/${person.id}" />">Detail</a>
                <a href="<c:url value="/delete-person/${person.id}" />">Remove</a>
                <a href="<c:url value="/update-person/${person.id}" />">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
