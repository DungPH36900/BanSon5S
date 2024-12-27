<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Liên kết CSS và JS của Toastr -->
<link href="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.js"></script>

<div>
    <h3>Thêm Thương Hiệu</h3>
    <a href="/admin/thuonghieu" class="btn mb-2"><i class="fa-solid fa-arrow-left"></i> Quay lại</a>
    <div class="card">
        <div class="card-body">
            <form id="brandForm" action="${action}" method="post">
                <input type="hidden" class="form-control" name="id" id="id" value="${brand.id}">

                <!-- Tên thương hiệu -->
                <div class="mb-3">
                    <label for="brandName" class="form-label">Tên thương hiệu</label>
                    <input type="text" class="form-control ${not empty errors['tenThuongHieu'] ? 'is-invalid' : ''}" name="tenThuongHieu" id="brandName" placeholder="Nhập tên thương hiệu" value="${brand.tenThuongHieu}">

                    <!-- Hiển thị lỗi nếu có -->
                    <c:if test="${not empty errors['tenThuongHieu']}">
                        <div class="invalid-feedback">
                            <c:forEach var="error" items="${errors['tenThuongHieu']}">
                                <p>${error}</p>
                            </c:forEach>
                        </div>
                    </c:if>
                </div>

                <div class="d-flex justify-content-end mt-4">
                    <button type="submit" class="btn btn-primary">${btnText}</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Script để hiển thị thông báo Toastr -->
<script>
    <c:if test="${not empty successMessage}">
    toastr.success("${successMessage}");
    </c:if>

    <c:if test="${not empty errorMessage}">
    toastr.error("${errorMessage}");
    </c:if>
</script>