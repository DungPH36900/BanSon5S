function toggleCustomerForm() {
    var checkBox = document.getElementById("giaoHangCheck");
    var form = document.getElementById("customerForm");

    if (checkBox.checked == true) {
        form.classList.remove("hidden");
    } else {
        form.classList.add("hidden");
    }
}

$(document).ready(function () {
    // Khi chọn tỉnh/thành phố, gọi API lấy quận/huyện
    $('#province').change(function () {
        var provinceId = $(this).val();
        $.ajax({
            url: '/districts',
            method: 'POST',
            data: {provinceId: provinceId},
            success: function (data) {
                console.log(data); // In ra để kiểm tra cấu trúc
                $('#district').empty();
                $('#district').append('<option value="" disabled selected> - Chọn quận/huyện - </option>');
                $.each(data.data, function (index, district) {
                    console.log(district); // In từng district ra để kiểm tra
                    $('#district').append('<option value="' + district.DistrictID + '">' + district.DistrictName + '</option>');
                });
            },
            error: function () {
                console.error(xhr.responseText);
                alert('Có lỗi khi tải danh sách quận/huyện.');
            }
        });
    });

    // Khi chọn quận/huyện, gọi API lấy xã/phường
    $('#district').change(function () {
        var districtId = $(this).val();
        $.ajax({
            url: '/wards',
            method: 'POST',
            data: {districtId: districtId},
            success: function (data) {
                console.log(data);
                $('#ward').empty();
                $('#ward').append('<option value="" disabled selected>Chọn xã/phường</option>');
                $.each(data.data, function (index, ward) {
                    console.log(ward);
                    $('#ward').append('<option value="' + ward.WardCode + '">' + ward.WardName + '</option>');
                });
            },
            error: function () {
                console.error(xhr.responseText);

                alert('Có lỗi khi tải danh sách xã/phường.');
            }
        });
    });
});
$(document).ready(function() {
    // Hiển thị pop-up khi nhấn nút chọn phương thức thanh toán
    $("#paymentMethodBtn").click(function() {
        $("#paymentPopup").css("display", "flex");
    });

    // Đóng pop-up khi nhấn dấu "x"
    $(".close").click(function() {
        $("#paymentPopup").css("display", "none");
    });

    // Đóng pop-up khi nhấn bên ngoài modal
    $(window).click(function(event) {
        if (event.target.id === "paymentPopup") {
            $("#paymentPopup").css("display", "none");
        }
    });

    // Xử lý khi chọn phương thức thanh toán
    $("#chuyenKhoanBtn").click(function() {
        $("#chuyenKhoanForm").show();
        $("#tienMatForm").hide();
    });

    $("#tienMatBtn").click(function() {
        $("#chuyenKhoanForm").hide();
        $("#tienMatForm").show();
    });
});

