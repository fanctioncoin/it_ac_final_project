<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css"/>
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for adding the coach!
</h1>
<form action="/add-coach" method="post">
    <input required type="text" name="username" placeholder="Логин">
    <input required type="text" name="password" placeholder="Пароль">
    <input required type="text" name="name" placeholder="Имя">
    <input required type="text" name="age" placeholder="Возраст">
    <input required type="text" name="salary" placeholder="Зарплата">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
