<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SanPham</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
<h1>Quản lý sản phẩm</h1>
<div class="display: flex; justify-content:center; width: 100%">
    <form method="GET" action="/san-pham/index">
        <input name="key">
        <button>Tìm kiếm</button>
    </form>
</div>
<div>
    <button type="button" style="margin-right: 10px; padding: 5px;">Làm mới</button>
</div>
<div>
    <a href="">Tạo sản phẩm </a>
</div>
<!-- Combobox Danh mục -->
<select name="danhMuc" style="margin-right: 10px; padding: 5px;">
    <option value="">Danh mục</option>
    <c:forEach items="${dsDanhMuc}" var="dm">
        <option value="${dm.id}">${dm.tenDanhMuc}</option>
    </c:forEach>
</select>

<!-- Combobox Xuất xứ -->
<select name="xuatXu" style="margin-right: 10px; padding: 5px;">
    <option value="">Xuất xứ</option>
    <c:forEach items="${dsXuatXu}" var="xx">
        <option value="${xx.id}">${xx.tenXuatXu}</option>
    </c:forEach>
</select>

<!-- Combobox Thương hiệu -->
<select name="thuongHieu" style="margin-right: 10px; padding: 5px;">
    <option value="">Thương hiệu</option>
    <c:forEach items="" var="th">
        <option value=""></option>
    </c:forEach>
</select>

<table class="table" border="1">
    <tr>
        <th>STT</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng đã bán</th>
        <th>Xuất xứ</th>
        <th>Danh mục</th>
        <th>Thương hiệu</th>
        <th>Trạng Thái</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach items="${dssp}" var="sp" varStatus="i">
        <tr>
            <td scope="row">${i.index + 1}</td>
            <td>${sp.tenSanPham}</td>
            <td>${sp.soLuongDaBan}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.xuatXu.tenXuatXu}</td>
            <td>${sp.danhMuc.tenDanhMuc}</td>
            <td>${sp.thuongHieu.tenThuongHieu}</td>
            <td>${sp.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td> <!-- Thay sv thành sp -->
            <td>
                <a href="" title="Chi tiết">
                    <i class="fas fa-eye"></i>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
