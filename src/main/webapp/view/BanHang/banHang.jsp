<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Đặt Hàng</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <link rel="stylesheet" type="text/css" href="../static/BanHang/banHangView.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<%--<jsp:include page="../../includes/header.jsp"/>--%>

<div class="container">
    <h2>Khách hàng</h2>

    <div class="form-group">
        <label for="tenKhachHang">Tên Khách hàng</label>
        <input type="text" id="tenKhachHang" value="" disabled>
    </div>

    <div class="form-group">
        <input type="checkbox" id="giaoHangCheck" onchange="toggleCustomerForm()"> Giao hàng
    </div>

    <div id="customerForm" class="hidden">
        <div class="form-group">
            <label for="tenNguoiNhan">Tên người nhận</label>
            <input type="text" id="tenNguoiNhan" placeholder="Nhập tên người nhận">
        </div>

        <div class="form-group">
            <label for="soDienThoai">Số điện thoại</label>
            <input type="text" id="soDienThoai" placeholder="Nhập số điện thoại">
        </div>

        <div class="flex">
            <div class="form-group">
                <label for="province">Tỉnh/Thành phố:</label>
                <select id="province" name="province">
                    <option value="" disabled>Chọn tỉnh/thành phố</option>

                    <c:if test="${not empty provinces}">
                        <c:forEach var="t" items="${provinces}">
                            <option value="${t.provinceID}">${t.provinceName}</option>
                        </c:forEach>
                    </c:if>

                    <c:if test="${empty provinces}">
                        <option value="" disabled>Không có tỉnh/thành phố nào được tìm thấy.</option>
                    </c:if>
                </select>
            </div>
            <div class="form-group">
                <label for="district">Quận/Huyện:</label>
                <select id="district" name="district" required>
                    <option value="" disabled selected> - Chọn quận/huyện -</option>
                </select>
            </div>
        </div>

        <div class="flex">
            <div class="form-group">
                <label for="ward">Xã/Phường:</label>
                <select id="ward" name="ward" required>
                    <option value="" disabled selected>Chọn xã/phường</option>
                </select>
            </div>
            <div class="form-group">
                <label for="diaChiCuThe">Địa chỉ cụ thể</label>
                <input type="text" id="diaChiCuThe" placeholder="Nhập địa chỉ cụ thể">
            </div>
        </div>

        <div class="form-group">
            <label for="ghiChu">Ghi chú</label>
            <input type="text" id="ghiChu" placeholder="Nhập ghi chú nếu có">
        </div>
    </div>

    <div class="summary">
        <p>Tiền hàng: 137.500 VND</p>
        <p>Phí vận chuyển: 34.000 VND</p>
        <p>Giảm giá: 13.750 VND</p>
        <hr>
        <p><b>Tổng số tiền: 157.750 VND</b></p>
        <p>Khách thanh toán:
            <button id="paymentMethodBtn" class="button">Chọn</button>
            0 VND
        </p>
        <p><b>Tiền thiếu: 157.750 VND</b></p>
    </div>
    <!-- Pop-up Phương Thức Thanh Toán -->
    <div id="paymentPopup" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Thanh Toán</h2>
            <button id="chuyenKhoanBtn" class="payment-method-btn">Chuyển Khoản</button>
            <button id="tienMatBtn" class="payment-method-btn">Tiền Mặt</button>

            <!-- Form nhập liệu tùy thuộc vào phương thức thanh toán -->
            <div id="chuyenKhoanForm" class="transaction-info" style="display:none;">
                <label for="transactionCode">Mã giao dịch:</label>
                <input type="text" id="transactionCode" placeholder="Nhập mã giao dịch">
                <label for="amountPaidCK">Số tiền đã trả:</label>
                <input type="number" id="amountPaidCK" placeholder="Nhập số tiền đã trả">
            </div>

            <div id="tienMatForm" class="transaction-info" style="display:none;">
                <label for="amountPaidTM">Số tiền đã trả:</label>
                <input type="number" id="amountPaidTM" placeholder="Nhập số tiền đã trả">
            </div>

            <p><b>Tiền thiếu: 157.750 VND</b></p>
            <button class="confirm-btn">Xác nhận</button>
        </div>
    </div>
    <button class="button">Xác nhận đặt hàng</button>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/BanHang/banHang.js"></script>

<jsp:include page="../../includes/footer.jsp"/>
</body>
</html>
