<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<h1>Giỏ hàng của bạn</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Sản phẩm</th>
        <th>Số lượng</th>
        <th>Tổng tiền</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="gioHang" items="${gioHangs}">
        <tr>
            <td>${gioHang.id}</td>
            <td>${gioHang.sanPhamChiTiet.tenSanPham}</td>
            <td>${gioHang.soLuong}</td>
            <td>${gioHang.tongTien}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form action="/them-vao-gio-hang" method="post">
    <input type="number" name="idSanPhamChiTiet" placeholder="ID Sản phẩm chi tiết" required />
    <input type="number" name="idKhachHang" placeholder="ID Khách hàng" required />
    <input type="number" name="soLuong" placeholder="Số lượng" required />
    <button type="submit">Thêm vào giỏ hàng</button>
</form>
</body>
</html>
