package com.example.banson5s.BanHang.Controller;

import com.example.banson5s.BanHang.Entity.HoaDon;
import com.example.banson5s.BanHang.Entity.HoaDonRequest;
import com.example.banson5s.BanHang.Entity.PhuongThucThanhToan;
import com.example.banson5s.BanHang.Repository.HoaDonRepo;
import com.example.banson5s.BanHang.Repository.KhachHangRepo;
import com.example.banson5s.BanHang.Repository.NhanVienRepo;
import com.example.banson5s.BanHang.Repository.PhuongThucThanhToanRepo;
import com.example.banson5s.BanHang.Service.HoaDonService;
import com.example.banson5s.ChucNang.Entity.KhachHang;
import com.example.banson5s.ChucNang.Entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BHContro {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private KhachHangRepo khachHangRepo;

    @Autowired
    private NhanVienRepo nhanVienRepo;

    @Autowired
    private PhuongThucThanhToanRepo phuongThucThanhToanRepo;

    @Autowired
    private HoaDonRepo hoaDonRepo;

    @GetMapping("/hien-thi/hoa-don/tao-moi")
    public String showCreateForm(Model model, @RequestParam(required = false) String maHD) {
        // Load danh sách khách hàng, nhân viên, PTTT
        model.addAttribute("khachHangs", khachHangRepo.findAll());
        model.addAttribute("nhanViens", nhanVienRepo.findAll());
        model.addAttribute("phuongThucThanhToans", phuongThucThanhToanRepo.findAll());

        // Lấy danh sách hóa đơn để hiển thị
        model.addAttribute("hoaDons", hoaDonRepo.findAll());

        // Nếu có mã hóa đơn (sau khi tạo), hiển thị mã hóa đơn trên form
        model.addAttribute("maHD", maHD);

        return "/BanHang/banhan"; // Trang JSP cần hiển thị
    }


//    @PostMapping("/hien-thi/add/tao-trong")
//    public String createEmptyHoaDon(@RequestParam(required = false) Long khachHangId,
//                                    RedirectAttributes redirectAttributes) {
//        // Lấy danh sách tất cả hóa đơn hiện có (hoặc có thể lấy những hóa đơn trống)
//        List<HoaDon> hoaDonList = hoaDonRepo.findByTrangThai(0); // Giả sử trạng thái 0 là hóa đơn trống
//
//        // Kiểm tra số lượng hóa đơn trống hiện có
//        if (hoaDonList.size() >= 5) {
//            // Thêm thông báo lỗi vào flash attribute
//            redirectAttributes.addFlashAttribute("error", "Chỉ được phép tạo tối đa 5 hóa đơn trống.");
//            // Chuyển hướng lại trang hiển thị danh sách hóa đơn
//            return "redirect:/hien-thi/hoa-don/tao-moi";
//        }
//
//        // Nếu chưa vượt quá giới hạn, tạo hóa đơn trống mới
//        HoaDon hoaDon = hoaDonService.createEmptyHoaDon(khachHangId);
//
//        // Truyền danh sách hóa đơn đã tạo vào flash attribute
//        redirectAttributes.addFlashAttribute("hoaDonList", hoaDonList);
//
//        // Chuyển hướng lại trang hiển thị danh sách hóa đơn, kèm mã hóa đơn mới tạo
//        return "redirect:/hien-thi/hoa-don/tao-moi";
//    }


    @PostMapping("/hien-thi/add/tao-trong")
    public String createEmptyHoaDon(@RequestParam(required = false) Long khachHangId,
                                    RedirectAttributes redirectAttributes) {
        // Tạo hóa đơn trống mới
        HoaDon hoaDon = hoaDonService.createEmptyHoaDon(khachHangId);

        // Lấy danh sách hóa đơn trống hiện có sau khi tạo hóa đơn mới
        List<HoaDon> hoaDonList = hoaDonRepo.findByTrangThai(0); // Lấy hóa đơn có trạng thái là trống

        // Kiểm tra số lượng hóa đơn trống
        if (hoaDonList.size() >= 5) {
            redirectAttributes.addFlashAttribute("error", "Chỉ được phép tạo tối đa 5 hóa đơn trống.");
            return "redirect:/hien-thi/hoa-don/tao-moi";
        }

        // Truyền danh sách hóa đơn đã tạo vào flash attribute
        redirectAttributes.addFlashAttribute("hoaDonList", hoaDonList);

        // Chuyển hướng lại trang hiển thị danh sách hóa đơn, kèm mã hóa đơn mới tạo
        return "redirect:/hien-thi/hoa-don/tao-moi";
    }

}
