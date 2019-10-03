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
<html>
<link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resource/js/main.js"/>'></script>
<head>
    <title>Title</title>
</head>
<body>
<p>Information of user</p>
<p>Name: <i>${person.name}</i></p>
<p>Age: <i>${person.age}</i></p>
<p>Gender: <i>${person.gender}</i></p>
<c:forEach items="${person.listFavorite}" var="item">
    <p>${item}</p>
</c:forEach>
<img src="<c:url value="/resource/image/3.jpg" />" width="100%">
</body>
</html>
