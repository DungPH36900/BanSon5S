package com.example.banson5s.BanHang.Controller;

import com.example.banson5s.BanHang.Entity.GioHang;
import com.example.banson5s.BanHang.Service.GioHangService;
import com.example.banson5s.ChucNang.Entity.KhachHang;
import com.example.banson5s.SanPham.Entity.SanPhamChiTiet;
import com.example.banson5s.SanPham.Service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private SanPhamChiTietService sanPhamChiTietService;

    @GetMapping("/gio-hang")
    public String viewGioHang(Model model) {
        model.addAttribute("gioHangs", gioHangService.getAllGioHangs());
        return "gio-hang"; // Tên file JSP
    }

    @PostMapping("/them-vao-gio-hang")
    public String addToCart(@RequestParam Long idSanPhamChiTiet, @RequestParam Long idKhachHang, @RequestParam int soLuong) {
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.findById(idSanPhamChiTiet);
        if (sanPhamChiTiet == null) {
            return "redirect:/gio-hang?error=product_not_found";
        }

        GioHang gioHang = new GioHang();
        gioHang.setSanPhamChiTiet(sanPhamChiTiet);
        gioHang.setKhachHang(new KhachHang(idKhachHang));
        gioHang.setSoLuong(soLuong);


        double giaSanPham = sanPhamChiTiet.getGiaBan().doubleValue();
        gioHang.setTongTien(soLuong * giaSanPham); // Tính tổng tiền
        gioHangService.addToCart(gioHang);
        return "redirect:/gio-hang";
    }
}
