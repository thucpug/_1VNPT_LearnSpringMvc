<%--
  Created by IntelliJ IDEA.
  User: ThucPug
  Date: 10/3/2019
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src='<c:url value="/resource/js/main.js"/>'></script>
<head>
    <title>Title</title>
</head>
<body>
<p>Form UploadFile</p>
<c:url value="/uploadfile" var="url"></c:url>
<form method="post" action="${url}" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">Submit</button>
</form>
</body>
</html>
