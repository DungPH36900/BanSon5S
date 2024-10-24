<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Quản lý </title>
    <head>
        <style>
            .container {
                width: 80%;
                margin: auto;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 5px;
                background-color: #f9f9f9;
            }

            .order-section {
                display: flex;
                flex-direction: column;
                align-items: flex-start;
                justify-content: space-between;
                padding-bottom: 15px;
                border-bottom: 1px solid #ddd;
            }

            .btn-create-order {
                background-color: orange;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-weight: bold;
                transition: background-color 0.3s ease;
            }

            .btn-create-order:hover {
                background-color: darkorange;
            }

            .product-section {
                margin-top: 20px;
                border-top: 1px solid #ddd;
                padding-top: 10px;
            }

            .no-data {
                text-align: center;
                color: #888;
                margin-top: 20px;
                font-style: italic;
            }

            /* Căn giữa thông báo "No Data Found" với hình ảnh */
            .no-data img {
                display: block;
                margin: 0 auto;
                max-width: 100px;
                opacity: 0.6;
            }

            .no-data p {
                color: #666;
                font-size: 16px;
                margin-top: 10px;
            }

            .alert-success {
                background-color: #d4edda;
                color: #155724;
                border: 1px solid #c3e6cb;
                padding: 10px;
                border-radius: 4px;
                margin-bottom: 15px;
                margin-top: 10px; /* Tạo khoảng cách phía trên thông báo */
                width: 100%;
            }

            /* Căn chỉnh lại form và nút để hiển thị theo chiều ngang */
            .form-container {
                display: flex;
                align-items: center;
                justify-content: space-between;
                width: 100%;
                margin-top: 15px;
            }

            /* Căn chỉnh lại select */
            .form-container .form-select {
                width: 250px;
                margin-right: 15px;
            }
        </style>
    </head>
<body>
<div class="container">


    <div class="order-section">
        <h3>Đơn hàng</h3>

        <!-- Hiển thị mã hóa đơn mới tạo nếu có -->

<%--        <c:if test="${not empty maHD}">--%>
<%--            <div class="alert alert-success">--%>
<%--                <strong>${maHD}</strong>--%>
<%--            </div>--%>
<%--        </c:if>--%>

        <!-- Hiển thị danh sách hóa đơn trống đã tạo -->
        <c:if test="${not empty hoaDonList}">
            <div class="alert alert-success">
                <strong>Danh sách hóa đơn trống vừa tạo:</strong>
                <ul>
                    <c:forEach items="${hoaDonList}" var="hoaDon" varStatus="status">
                        <li>
                            <!-- Hiển thị đơn hàng với số thứ tự và mã hóa đơn -->
                            <input type="radio" name="selectedHoaDon" value="${hoaDon.maHD}"/>
                            Đơn hàng ${status.index + 1} - Mã: ${hoaDon.maHD}
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <strong>${error}</strong>
            </div>
        </c:if>




        <!-- Form tạo hóa đơn trống -->
        <form class="form-container" action="${pageContext.request.contextPath}/hien-thi/add/tao-trong" method="post">
            <div class="mb-3">
                <label for="khachHangId" class="form-label">Khách Hàng</label>
                <select id="khachHangId" name="khachHangId" class="form-select">
                    <option value="">Chọn khách hàng</option>
                    <c:forEach items="${khachHangs}" var="khachHang">
                        <option value="${khachHang.id}">${khachHang.hoTen}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn-create-order">+ Tạo hóa đơn trống</button>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-7mNSRPxGqqDO6mP1Bhv12R9en4eTB3twK26PV2ddmkwElzRVXg2jAVTAu7WwG3Ff" crossorigin="anonymous"></script>
</body>


</html>
