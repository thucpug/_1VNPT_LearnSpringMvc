<%--
  Created by IntelliJ IDEA.
  User: ThucPug
  Date: 10/7/2019
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Detail Person</h1>
<hr>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Gioi tinh</th>
    </tr>
    <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.gender}</td>
    </tr>
</table>
</body>
</html>
