package com.example.banson5s.BanHang.Service;

import com.example.banson5s.BanHang.Entity.HoaDon;
import com.example.banson5s.BanHang.Entity.PhuongThucThanhToan;
import com.example.banson5s.BanHang.Repository.HoaDonRepo;
import com.example.banson5s.BanHang.Repository.KhachHangRepo;
import com.example.banson5s.BanHang.Repository.NhanVienRepo;
import com.example.banson5s.BanHang.Repository.PhuongThucThanhToanRepo;
import com.example.banson5s.ChucNang.Entity.KhachHang;
import com.example.banson5s.ChucNang.Entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    HoaDonRepo hoaDonRepo1;


    public HoaDon createEmptyHoaDon(Long khachHangId) {
        HoaDon hoaDon = new HoaDon();
        if (khachHangId != null) {
            hoaDon.setKhachHang(new KhachHang(khachHangId));
        } else {
            // Tạo một khách hàng mặc định nếu cần
            // hoaDon.setKhachHang(defaultKhachHang);
        }
        hoaDon.setMaHD("HD-" + System.currentTimeMillis()); // Tạo mã hóa đơn ngẫu nhiên
        return hoaDonRepo1.save(hoaDon); // Lưu hóa đơn
    }

}
