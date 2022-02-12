
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Band</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for students!<br>
    Please chose band!
</h1>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Name </td>
        <td>Coach</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${bands}" var = "band">
        <tr>
            <td>${band.id}</td>
            <td>${band.name} </td>
            <td>${band.coach.name} </td>
            <td>
                <form action = "/choose-band" method="post">
                    <input type="hidden" name="id" value="${band.id}">
                    <input type="submit" value="Select" style="float:left">
                </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
