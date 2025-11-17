<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/17/2025
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <c:import url="head.jsp"></c:import>

<body>
<script>
    function displayToast(message, color) {
        document.getElementById("toastContent").innerHTML = message;
        document.getElementById("liveToast").style.background = color;
        let myAlert = document.getElementById('liveToast');//select id of toast
        let bsAlert = new bootstrap.Toast(myAlert);//inizialize it
        bsAlert.show();//show it
    }
</script>
<c:import url="navbar.jsp"></c:import>
<body style="font-family: Arial, sans-serif; margin:0; padding:0; background-color:#f8f9fa;">

<!-- Banner -->
<section class="text-white text-center py-5" style="background-color:#7952B3;">
    <div class="container">
        <h1 class="display-4 fw-bold">Chào mừng đến với Ngân Hàng XYZ</h1>
        <p class="lead">Dịch vụ tài chính an toàn, nhanh chóng và tiện lợi.</p>
        <a href="#services" class="btn btn-warning btn-lg mt-3">Khám phá dịch vụ</a>
    </div>
</section>

<!-- Các dịch vụ -->
<section id="services" class="py-5">
    <div class="container">
        <h2 class="text-center mb-4" style="color:#7952B3;">Dịch vụ nổi bật</h2>
        <div class="row g-4">

            <!-- Dịch vụ 1 -->
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <i class="bi bi-bank2" style="font-size: 2rem; color:#7952B3;"></i>
                        <h5 class="card-title mt-3">Tài khoản tiết kiệm</h5>
                        <p class="card-text">Lãi suất hấp dẫn, quản lý tài khoản dễ dàng, an toàn tuyệt đối.</p>
                        <a href="#" class="btn btn-warning">Đăng ký</a>
                    </div>
                </div>
            </div>

            <!-- Dịch vụ 2 -->
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <i class="bi bi-credit-card" style="font-size: 2rem; color:#7952B3;"></i>
                        <h5 class="card-title mt-3">Thẻ tín dụng</h5>
                        <p class="card-text">Thanh toán dễ dàng, ưu đãi hấp dẫn, chi tiêu an toàn.</p>
                        <a href="#" class="btn btn-warning">Đăng ký</a>
                    </div>
                </div>
            </div>

            <!-- Dịch vụ 3 -->
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <i class="bi bi-cash-stack" style="font-size: 2rem; color:#7952B3;"></i>
                        <h5 class="card-title mt-3">Cho vay cá nhân</h5>
                        <p class="card-text">Vay nhanh, lãi suất hợp lý, giải ngân trong 24h.</p>
                        <a href="#" class="btn btn-warning">Tìm hiểu</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- Thông tin ngân hàng -->
<section class="py-5" style="background-color:#e9ecef;">
    <div class="container text-center">
        <h2 style="color:#7952B3;">Về chúng tôi</h2>
        <p>Ngân hàng XYZ với hơn 20 năm kinh nghiệm, phục vụ hàng triệu khách hàng trên toàn quốc, cung cấp các giải
            pháp tài chính đa dạng, an toàn và hiệu quả.</p>
    </div>
</section>

<!-- Footer -->
<footer class="text-white py-4" style="background-color:#7952B3;">
    <div class="container text-center">
        <p>© 2025 Ngân Hàng XYZ. All rights reserved.</p>
        <p>Địa chỉ: 123 Đường ABC, TP. Hà Nội | Hotline: 1900 1234</p>
    </div>
</footer>


<%--toast--%>
<div class="position-fixed top-0 end-5 p-3" style="z-index: 11;margin-left: 500px">
    <div id="liveToast" style="width: 230px; color: white; background:lightgreen ;border-radius:0%/0%;" class="toast"
         role="dialog" aria-live="assertive" aria-atomic="true">
        <div class="toast-body">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="30px" height="30px">
                <g id="surface1_4_">
                    <path style="fill:#4CAF50;"
                          d="M44,24c0,11.045-8.955,20-20,20S4,35.045,4,24S12.955,4,24,4S44,12.955,44,24z"/>
                    <path style="fill:#CCFF90;"
                          d="M34.602,14.602L21,28.199l-5.602-5.598l-2.797,2.797L21,33.801l16.398-16.402L34.602,14.602z"/>
                </g>
            </svg>
            <span id="toastContent">Nội dung hiển thị</span>
        </div>
    </div>
</div>
<script>

    <c:if test="${loginSuccess}">
    displayToast("Đăng nhập thành công", "green")
    document.getElementById("new").style.display = "inline";
    </c:if>

    <c:if test="${logoutSuccess}">
    displayToast("Bạn đã đăng xuất", "orange")
    // hiển thị icon new giỏ hàng
    document.getElementById("new").style.display = "inline";
    </c:if>

<%--    <c:if test="${param.mess!=null}">--%>
<%--    displayToast("Đăng nhập thành công", "orange")--%>
<%--    </c:if>--%>
<%--    <c:if test="${param.successBuy!=null}">--%>
<%--    displayToast("Đã đặt hàng thành công! <br>" +--%>
<%--        "<pre style= 'color: darkorange'>  Kiểm tra mail xem chi tiết</pre>", "green")--%>
<%--    </c:if>--%>

</script>

<!-- Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</body>

</html>
