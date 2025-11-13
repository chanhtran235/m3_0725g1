<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/13/2025
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student list</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/my_nabar.jsp"/>
<h2> Add new student</h2>
<form action="/students?action=add" method="post">
    <input name="id" placeholder="Enter id"><br>
    <input name="name" placeholder="Enter name"><br>
    <input type="radio" name="gender" value="0">Female
    <input type="radio" name="gender" value="1">Male<br>
    <input  name="score" placeholder="Enter score">Score<br>
    <button>Save</button>
</form>
</body>
</html>
