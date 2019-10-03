<%--
  Created by IntelliJ IDEA.
  User: ThucPug
  Date: 10/3/2019
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resource/js/main.js"/>'></script>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello ${msg}</h1>
<img  src="<c:url value="/resource/image/3.jpg" />" width="100%">
</body>
</html>
