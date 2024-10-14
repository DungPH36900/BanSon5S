package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Entity.SanPham;
import com.example.banson5s.SanPham.Entity.ThuongHieu;
import com.example.banson5s.SanPham.Entity.XuatXu;
import com.example.banson5s.SanPham.Repositorty.DanhMucRepositorty;
import com.example.banson5s.SanPham.Repositorty.SanPhamRepositorty;
import com.example.banson5s.SanPham.Repositorty.ThuongHieuRepositorty;
import com.example.banson5s.SanPham.Repositorty.XuatXuRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamRepositorty spRepo;

    @Autowired
    private DanhMucRepositorty dmRepo; // Tiêm repository danh mục

    @Autowired
    private XuatXuRepositorty xxRepo; // Tiêm repository xuất xứ

    @Autowired
    private ThuongHieuRepositorty thRepo; // Tiêm repository thương hiệu

    // Hiện danh sách sản phẩm
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dssp", spRepo.findAll());
        model.addAttribute("dsDanhMuc", dmRepo.findAll());
        model.addAttribute("dsXuatXu", xxRepo.findAll());
        model.addAttribute("dsThuongHieu", thRepo.findAll());
        return "SanPham/san_pham/index";
    }

    // Hiện form tạo sản phẩm
    @GetMapping("/create")
    public String hienThiFormTao(Model model) {
        model.addAttribute("sanPham", new SanPham());

        // Lấy danh sách danh mục, xuất xứ, và thương hiệu
        List<DanhMuc> dsDanhMuc = dmRepo.findAll();
        model.addAttribute("dsDanhMuc", dsDanhMuc);

        List<XuatXu> dsXuatXu = xxRepo.findAll();
        model.addAttribute("dsXuatXu", dsXuatXu);

        List<ThuongHieu> dsThuongHieu = thRepo.findAll();
        model.addAttribute("dsThuongHieu", dsThuongHieu);

        return "SanPham/san_pham/create";
    }

    // Xử lý việc thêm sản phẩm mới
    @PostMapping("/create")
    public String taoSanPham(@ModelAttribute SanPham sanPham) {
        spRepo.save(sanPham);
        return "redirect:/san-pham/index";
    }
}
