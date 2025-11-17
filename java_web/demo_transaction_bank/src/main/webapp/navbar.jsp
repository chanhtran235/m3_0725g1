<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm">
    <div class="container-fluid d-flex justify-content-start align-items-center">
        <a class="navbar-brand icon" href="#">
            <img width="25" height="25" src="https://img.icons8.com/emoji/48/bouquet-emoji.png"
                 alt="bouquet-emoji"/>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="text-white">Menu</span>
        </button>
        <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a style="color: white" class="nav-link" href="/transfer">Transfer</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
            </ul>
            <div class="d-flex justify-content-end">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="text-primary text-decoration-none" href="#">
                        ${sessionScope.accountBank.username}</a></li>
                    <li class="nav-item"><a class="text-primary text-decoration-none" href="#">
                        <img width="20" height="20" src="https://img.icons8.com/emoji/48/blossom.png"
                             alt="blossom"/></a>
                    </li>
                    <c:if test="${sessionScope.accountBank==null}">
                        <li class="nav-item"><a class="text-white text-decoration-none" href="/login">login</a></li>
                    </c:if>
                    <c:if test="${sessionScope.accountBank!=null}">
                        <li class="nav-item"><a class="text-white text-decoration-none" href="/logout">logout</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</nav>
