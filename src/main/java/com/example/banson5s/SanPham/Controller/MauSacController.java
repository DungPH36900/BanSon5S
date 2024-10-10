package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Entity.MauSac;
import com.example.banson5s.SanPham.Repositorty.MauSacRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepositorty msRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dsms", msRepo.findAll());
        return "mau_sac/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("data1",msRepo.findById(id).get());
        model.addAttribute("data",msRepo.findAll());
        return "mau_sac/index";
    }
    @PostMapping("add")
    public String add(MauSac ms){
        msRepo.save(ms);
        return "redirect:/mau-sac/index";
    }
}
