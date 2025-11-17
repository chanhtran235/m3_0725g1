<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import>
<body>
<c:import url="navbar.jsp"></c:import>

<form action="/login" method="post" class="w-25" style="margin-left: 300px" >
    <h4>Đăng nhập</h4>
    <div class="mb-3">
        <label for="username" class="form-label">Tên tài khoản</label>
        <input  name="username" type="text" class="form-control" id="username" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Mập khâu</label>
        <input name="password" type="password" class="form-control" id="password">
    </div>
    <div class="mb-3 form-check">
        <input name="remember" type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Ghi nhớ</label>
    </div>
    <button type="submit" class="btn btn-sm btn-outline-warning" style="background-color: #7952B3;color: orange" >Login</button>
</form>
</body>
</html>
