<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Student</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<%@include file="/fragment/header.jsp" %>

<h3 align="center">
    Редактировать оценки: ${student.get().name}
</h3>
<h4> Предмет: ${student.get().band.disciplines.get(count)} </h4>
<form action="/refresh-student" method="post">
    <input type="hidden" name="id" value="${student.get().id}">
    <input type="hidden" name="count" value="${count}">
    <input required type="text" name="grade" placeholder="${student.get().marks.get(count)}">
    <input type="submit" value="Save" style="float:left">
</form>
</body>
</html>
