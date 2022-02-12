<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List coaches</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css"/>
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h3 align="center"> List coaches!</h3>
<h4 align="center">
    Average salary of coaches:
    ${salary}
</h4>
<table border="2">
    <tr>
        <td><b>ID</b></td>
        <td><b>Username</b></td>
        <td><b>Password</b></td>
        <td><b>Enabled</b></td>
        <td><b>Role</b></td>
        <td><b>Name</b></td>
        <td><b>Age</b></td>
        <td><b>Salary</b></td>
        <td><b>Action</b></td>
    </tr>
    <c:forEach items="${coaches}" var="coach">
        <tr>
            <td>${coach.getId()}</td>
            <td>${coach.getCredUser().getUsername()} </td>
            <td>${coach.getCredUser().getPassword()} </td>
            <td>${coach.getCredUser().isEnabled()} </td>
            <td>${coach.getCredUser().getRoles().get(0).getName()}</td>
            <td>${coach.getName()}</td>
            <td>${coach.getAge()}</td>
            <td>${coach.getSalary()}</td>
            <td>
                <form action="/coach/update-coach.jsp" method="post">
                    <input type="hidden" name="id" value="${coach.getId()}">
                    <input type="hidden" name="name" value="${coach.getName()}">
                    <input type="hidden" name="age" value="${coach.getAge()}">
                    <input type="hidden" name="salary" value="${coach.getSalary()}">
                    <input type="submit" value="Edit" style="float:left">
                </form>
                <form action="/coach/delete-coach.jsp" method="post">
                    <input type="hidden" name="id" value="${coach.getId()}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <br>
    <form action="${pageContext.request.contextPath}/add-coach">
        <input type="submit" value="Add new coach">
    </form>
</div>
</body>
</html>
