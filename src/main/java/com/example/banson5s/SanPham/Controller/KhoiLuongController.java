package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Entity.KhoiLuong;
import com.example.banson5s.SanPham.Repositorty.KhoiLuongRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("khoi-luong")
public class KhoiLuongController {
    @Autowired
    private KhoiLuongRepositorty klRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dskl", klRepo.findAll());
        return "SanPham/khoi_luong/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("data1",klRepo.findById(id).get());
        model.addAttribute("data",klRepo.findAll());
        return "SanPham/khoi_luong/index";
    }
    @PostMapping("add")
    public String add(KhoiLuong kl){
        klRepo.save(kl);
        return "redirect:/khoi_luong/index";
    }
}
