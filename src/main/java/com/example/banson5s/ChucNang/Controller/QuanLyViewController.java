package com.example.banson5s.ChucNang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class QuanLyViewController {

    @GetMapping("/quan-ly-view")
    public String quanLySanPham(Model model) {

        return "quanLy";
    }
}