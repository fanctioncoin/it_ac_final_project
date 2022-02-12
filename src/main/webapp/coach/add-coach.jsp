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

<form:form modelAttribute="coachDto" action="/add-coach" methon="post">
    <form:label type="text" path="credUser.username">Username:</form:label>
    <form:input type="text" path="credUser.username"></form:input>
    <form:label type="text" path="credUser.password">Password:</form:label>
    <form:input type="text" path="credUser.password"></form:input>
    <form:label type="text" path="name">Name:</form:label>
    <form:input type="text" path="name"></form:input>
    <form:label type="text" path="age">Age:</form:label>
    <form:input type="text" path="age"></form:input>
    <form:label type="text" path="salary">Salary:</form:label>
    <form:input type="text" path="salary"></form:input>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
