package com.example.banson5s.SanPham.Controller;

import com.example.banson5s.SanPham.Entity.DanhMuc;
import com.example.banson5s.SanPham.Entity.MuiHuong;
import com.example.banson5s.SanPham.Repositorty.MuiHuongRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mui-huong")
public class MuiHuongController {
    @Autowired
    private MuiHuongRepositorty mhRepo;
    @GetMapping("/index")
    public String hienThi(Model model) {
        model.addAttribute("dsmh", mhRepo.findAll());
        return "mui_huong/index";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("data1",mhRepo.findById(id).get());
        model.addAttribute("data",mhRepo.findAll());
        return "mui_huong/index";
    }
    @PostMapping("add")
    public String add(MuiHuong mh){
        mhRepo.save(mh);
        return "redirect:/mui-huong/index";
    }
}
