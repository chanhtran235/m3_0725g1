<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import>
<body>
<c:import url="navbar.jsp"></c:import>

<form action="/transfer" class="w-50 px-5" method="post" style="background-color:#f4eaff;margin-left: 250px">
    <h2>Thông tin chuyển khoản</h2>
    <div class="d-flex justify-content-between">
        <div>
            <h3 style="color: red">${message}</h3>
        </div>
        <div>
            <span style=" font-weight: bold ;font-size :18px;color: red;text-align: right">${sessionScope.accountBank.totalMoney}</span>
            <span style="font-weight: bold;font-size: 18px;margin-left: 10px"> USD</span>
        </div>


    </div>

    <div>
        <label for="ownerName">Chủ tài khoản</label>
        <input name="ownerName" readonly value="${sessionScope.accountBank.ownerName}"
               class="form-control form-control-sm" id="ownerName">
    </div>
    <div>
        <label for="accountNumber">Số tài khoản chủ</label>
        <input name="accountSource" readonly value="${sessionScope.accountBank.accountNumber}"
               class="form-control form-control-sm" id="accountNumber">
    </div>
    <div>
        <label for="accountTarget">Số Tài khoản thụ hưởng</label>
        <input name="accountTarget" value="111" class="form-control form-control-sm" id="accountTarget">
    </div>
    <div>
        <label for="moneyTransfer">Số tiền (USD)</label>
        <input name="moneyTransfer" value="10000" class="form-control form-control-sm" id="moneyTransfer">
    </div>
    <div>
        <label for="content">Nội dung chuyển khoản</label>
        <textarea cols="5" rows="1" name="content" value="Chanhtv chuyển khoản" class="form-control"
                  id="content"></textarea>
    </div>
    <div class="d-flex justify-content-center">
        <button type="reset" class="btn btn-secondary btn-sm m-3">Nhập lại</button>
        <button type="submit" class="btn btn-warning btn-sm m-3">Thực hiện chuyển</button>
    </div>
</form>
</body>
</html>
