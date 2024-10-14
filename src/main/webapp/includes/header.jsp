<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>F Shoes Management</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        body {
            color: white; /* Màu chữ chắc (trắng) */
        }
        .sidebar {
            height: 100vh; /* Đặt chiều cao full màn hình */
            position: fixed; /* Cố định sidebar */
            top: 0; /* Bắt đầu từ đỉnh màn hình */
            left: 0; /* Bắt đầu từ trái màn hình */
            width: 20%; /* Độ rộng của sidebar là 20% */
            max-width: 300px; /* Đặt chiều rộng tối đa cho sidebar */
            z-index: 1000; /* Đặt z-index để không bị chồng lấp */
            background-color: #b85555; /* Màu nền cho sidebar */
            padding: 20px; /* Padding cho sidebar */
        }

        /* Style cho nội dung chính */
        .content {
            margin-left: 20%; /* Đẩy nội dung sang phải để không bị chồng lấp với sidebar */
            padding: 10px; /* Padding cho nội dung */
            border-radius: 5px; /* Bo góc cho nội dung chính */
            color: black; /* Màu chữ cho nội dung chính (trắng) */
            background-color: white;
            max-width: 80%;
        }

        /* Màu chữ cho tiêu đề */
        h2 {
            color: black; /* Màu chữ tiêu đề trắng */
        }
        .nav-item{
            margin: 9px 0;
        }
        .nav-link {
            transition: color 0.3s; /* Thêm hiệu ứng chuyển màu */
        }

        .nav-link:hover {
            color: #d81b60; /* Màu khi di chuột */
            opacity: 0.8; /* Giảm độ sáng của chữ một chút khi hover */
        }
        .logo {
            text-align: center; /* Căn giữa nội dung bên trong */
            margin: 20px 0; /* Khoảng cách trên và dưới */
        }

        .logo img {
            width: 105px; /* Chiều rộng của ảnh */
            height: 80px; /* Chiều cao của ảnh */
            margin: 14px auto; /* Khoảng cách trên và dưới là 15px, tự động căn giữa */
            display: block; /* Để ảnh có thể căn giữa theo margin auto */
            object-fit: contain; /* Đảm bảo ảnh không bị biến dạng */
        }

        #productManagement .nav-item {
            margin: 0; /* Không có khoảng cách cho các nav-item trong productManagement */
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-2 d-none d-md-block sidebar">
            <div class="sidebar-sticky">
                <div class="logo">
                    <img src="/img/Logo.jpg" alt="Logo" class="img-fluid text-center" />
                </div>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active text-white h5" href="#">
                            Thống kê
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white h5" href="#">
                            Bán hàng tại quầy
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white h5" href="#">
                            Quản lý đơn hàng
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white h5" data-toggle="collapse" href="#productManagement" role="button"
                           aria-expanded="false" aria-controls="productManagement">
                            Quản lý sản phẩm <i class="fas fa-chevron-down"></i>
                        </a>
                        <div class="collapse" id="productManagement">
                            <ul class="nav flex-column ml-3">
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="">Sản phẩm</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="#">Khối lượng</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="#">Mùi Hương</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="#">Màu Sắc</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="#">Xuất Xứ</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="#">Thương Hiệu</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-white h5" href="#">Danh Mục</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link text-white h5" href="#">
                            Trả hàng
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white h5" href="#">
                            Giảm giá
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white h5" href="#">
                            Tài khoản
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Nội dung chính -->
        <main class="col-md-9 ml-sm-auto col-lg-10 px-4 content">
            <h2>Dashboard</h2>
            <p>Chào mừng đến với trang quản lý sản phẩm F Shoes!</p>
            <!-- Thêm nội dung khác tại đây -->
        </main>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
