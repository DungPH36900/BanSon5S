package com.example.banson5s.ChucNang.Controller;

import com.example.banson5s.ChucNang.Entity.KhachHang;
import com.example.banson5s.ChucNang.Repositorty.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangRepository khachHangRepository;

    @GetMapping("/index")
    public String listKhachHang(Model model) {
        model.addAttribute("data", khachHangRepository.findAll());
        return "ChucNang/khach-hang/index";
    }

    @PostMapping("/add")
    public String add(KhachHang khachHang){
        khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("list", khachHangRepository.findById(id).get());
        return "ChucNang/khach-hang/view-update";
    }

    @PostMapping("/update")
    public String update(KhachHang khachHang){
        khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("detail", khachHangRepository.findById(id).get());
        model.addAttribute("data", khachHangRepository.findAll());
        return "ChucNang/khach-hang/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }
}
