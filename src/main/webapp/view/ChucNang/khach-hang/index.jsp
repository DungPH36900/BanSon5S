<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" language="java" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/khach-hang/add" method="post">
    Ho ten: <input type="text" name="hoTen" value="${detail.hoTen}">
    <br>
    Sdt: <input type="text" name="sdt" value="${detail.sdt}">
    <br>
    Dia chi: <input type="text" name="diaChi" value="${detail.diaChi}">
    <br>
    Mat khau: <input type="text" name="matKhau" value="${detail.matKhau}">
    <br>
    Email: <input type="text" name="email" value="${detail.email}">
    <br>
    Ngay tao: <input type="date" name="ngayTao" value="${detail.ngayTao}">
    <br>
    Ngay sua: <input type="date" name="ngaySua" value="${detail.ngaySua}">
    <br>
    Ngay sinh: <input type="date" name="ngaySinh" value="${detail.ngaySinh}">
    <br>
    Trang thai: <input type="text" name="trangThai" value="${detail.trangThai}">
    <br>
    <button>Add</button>
</form>
<h1>QL Khách Hàng</h1>
<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ tên</th>
        <th>Sdt</th>
        <th>Địa chỉ</th>
        <th>Mật khẩu</th>
        <th>Ngày tạo</th>
        <th>Ngày sửa</th>
        <th>Ngày sinh</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <c:forEach  items="${data}" var="khachHang">
        <tr>
            <td>${khachHang.id}</td>
            <td>${khachHang.hoTen}</td>
            <td>${khachHang.sdt}</td>
            <td>${khachHang.diaChi}</td>
            <td>${khachHang.matKhau}</td>
            <td>${khachHang.ngayTao}</td>
            <td>${khachHang.ngaySua}</td>
            <td>${khachHang.ngaySinh}</td>
            <td>${khachHang.trangThai == '1' ? 'Đang hoạt động' : 'Ngừng hoạt động'}</td>
            <td>
                <a href="/khach-hang/view-update/${khachHang.id}">Update</a>
                <a href="/khach-hang/delete/${khachHang.id}">Delete</a>
                <a href="/khach-hang/detail/${khachHang.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>