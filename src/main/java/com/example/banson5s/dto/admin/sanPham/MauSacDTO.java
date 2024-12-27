package com.example.banson5s.dto.admin.sanPham;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MauSacDTO {
    private Long id;
    @NotNull(message = "Tên màu sắc không được để trống")
    @Size(min = 1, max = 50, message = "Tên màu sắc phải từ 1 đến 50 ký tự")
    private String tenMauSac;
}