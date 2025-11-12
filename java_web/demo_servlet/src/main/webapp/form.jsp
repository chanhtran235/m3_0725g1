<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/12/2025
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/sum">
    <input name="n1" value="${num1}" placeholder="nhập số thứ nhất">
    <input name="n2" value="${num1}" placeholder="nhập số thứ hai">
    <button> Tính tổng</button>
</form>
<h1>Kết quả là :${sum}</h1>
</body>
</html>
