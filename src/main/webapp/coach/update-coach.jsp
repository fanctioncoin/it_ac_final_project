
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update  coach</title>
  <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp"%>

<h3 align="center">
  Редактировать пользователя
</h3>

<form action="/update-coach" method="post" >
  <input type="hidden" name = "id" value="${param.id}">
  <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
  <input type="text" name="age" value="${param.age}" placeholder=${param.age}>
  <input type="text" name="salary" value="${param.salary}" placeholder=${param.salary}>
  <input type="submit" value="Обновить">
</form>
</body>
</html>
