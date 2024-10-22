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
<form action="/khach-hang/update" method="post">
    ID: <input type="text" name="id" value="${list.id}">
    <br>
    Ho ten: <input type="text" name="hoTen" value="${list.hoTen}">
    <br>
    Sdt: <input type="text" name="sdt" value="${list.sdt}">
    <br>
    Dia chi: <input type="text" name="diaChi" value="${list.diaChi}">
    <br>
    Mat khau: <input type="text" name="matKhau" value="${list.matKhau}">
    <br>
    Email: <input type="text" name="email" value="${list.email}">
    <br>
    Ngay tao: <input type="date" name="ngayTao" value="${list.ngayTao}">
    <br>
    Ngay sua: <input type="date" name="ngaySua" value="${list.ngaySua}">
    <br>
    Ngay sinh: <input type="date" name="ngaySinh" value="${list.ngaySinh}">
    <br>
    Trang thai: <input type="text" name="trangThai" value="${list.trangThai}">
    <br>
    <button>Save</button>
</form>

</body>
</html>