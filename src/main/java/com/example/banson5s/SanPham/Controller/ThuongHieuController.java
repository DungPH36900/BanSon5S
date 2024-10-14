package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Entity.ThuongHieu;
import com.example.banson5s.SanPham.Repositorty.ThuongHieuRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thuong-hieu")
public class ThuongHieuController {
    @Autowired
    private ThuongHieuRepositorty thRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dsth", thRepo.findAll());
        return "SanPham/thuong_hieu/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("data1",thRepo.findById(id).get());
        model.addAttribute("data",thRepo.findAll());
        return "SanPham/thuong_hieu/index";
    }
    @PostMapping("add")
    public String add(ThuongHieu th){
        thRepo.save(th);
        return "redirect:/thuong-hieu/index";
    }
}
