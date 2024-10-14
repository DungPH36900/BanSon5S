package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Repositorty.SanPhamChiTietRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("SPCT")
public class SanPhamChiTietController {
    @Autowired
    SanPhamChiTietRepositorty spctRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dsspct", spctRepo.findAll());
        return "SanPham/san_pham_chi_tiet/index";
    }
}
