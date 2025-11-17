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
<h1>${param.mess}</h1>
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
        <th>Delete</th>

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
            <td>
                <button onclick="infoDelete('${student.id}','${student.name}')" type="button"
                        class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>

</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/students?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá sinh viên : </span><span class="text-danger" id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function infoDelete(id, name) {
       document.getElementById("deleteId").value = id;
       document.getElementById("deleteName").innerHTML = name;
    }
</script>
</body>
</html>
