package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.SanPham;
import com.example.banson5s.SanPham.Repositorty.SanPhamRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamRepositorty spRepo;

    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dssp", spRepo.findAll());
        return "san_pham/index";
    }




}
