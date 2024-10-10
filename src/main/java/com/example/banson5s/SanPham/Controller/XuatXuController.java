package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Entity.XuatXu;
import com.example.banson5s.SanPham.Repositorty.XuatXuRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("xuat-xu")

public class XuatXuController {
    @Autowired
    private XuatXuRepositorty xxRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dsxx", xxRepo.findAll());
        return "xuat_xu/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("data1",xxRepo.findById(id).get());
        model.addAttribute("data",xxRepo.findAll());
        return "xuat_xu/index";
    }
    @PostMapping("add")
    public String add(XuatXu xx){
        xxRepo.save(xx);
        return "redirect:/xuat-xu/index";
    }
}
