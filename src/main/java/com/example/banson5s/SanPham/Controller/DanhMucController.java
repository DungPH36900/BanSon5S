package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Repositorty.DanhMucRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("danh-muc")
public class DanhMucController {
    @Autowired
    DanhMucRepositorty dmRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dsdm", dmRepo.findAll());
        return "SanPham/danh_muc/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("data1",dmRepo.findById(id).get());
        model.addAttribute("data",dmRepo.findAll());
        return "SanPham/danh_muc/index";
    }
    @PostMapping("add")
    public String add(DanhMuc dm){
        dmRepo.save(dm);
        return "redirect:/danh-muc/index";
    }

}
