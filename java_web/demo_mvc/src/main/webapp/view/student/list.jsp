<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/13/2025
  Time: 11:05 AM
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
<h2>Student List</h2>
<a class="btn btn-success btn-sm" href="/students?action=add">Add new student</a>
<table class="table table-dark table-striped">
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Score</th>
        <th>Rank</th>
        <th>Class name</th>

    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>
                <c:if test="${student.isGender()}">Nam</c:if>
                <c:if test="${!student.isGender()}">Nữ</c:if>
            </td>
            <td>${student.getScore()}</td>
            <td>
                <c:choose>
                    <c:when test="${student.getScore()>=8}">
                        Giỏi
                    </c:when>
                    <c:when test="${student.getScore()>=7}">
                        Khá
                    </c:when>
                    <c:when test="${student.getScore()>=5}">
                       Trung bình
                    </c:when>
                    <c:otherwise>
                        Yếu
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${student.getClassName()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
