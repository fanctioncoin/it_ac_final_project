
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Students</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for Lists students band ${param.name_band}!
</h1>
<table border="2">
    <tr>
        <td><b>ID</b></td>
        <td><b>Name</b></td>
        <td><b>Age</b></td>
        <td><b>Band</b></td>
        <td><b>Coach</b></td>
        <c:forEach items="${students.get(0).band.disciplines}" var = "dis">
            <td><b><c:out value="${dis}"/></b></td>
        </c:forEach>

    </tr>
        <tr>
        <c:forEach items="${students}" var="student" >
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.band.name}</td>
            <td>${student.band.coach.name}</td>
            <% Integer count = 0;%>
            <c:forEach items="${student.marks}" var = "marks">
                <td>
                    <c:out value="${marks}"/>
                    <form action="/get-student" method="post">
                        <input type="submit" value="..." style="float:revert;" >
                        <input type="hidden" name="id" value="${student.id}">
                        <input type="hidden" name="count" value=<%=count++%>>
                    </form>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
