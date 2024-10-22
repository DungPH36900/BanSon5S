package com.example.banson5s.SanPham.Service;

import com.example.banson5s.SanPham.Entity.SanPhamChiTiet;
import com.example.banson5s.SanPham.Repositorty.SanPhamChiTietRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SanPhamChiTietService {
    @Autowired
    private SanPhamChiTietRepositorty sanPhamChiTietRepository;

    // Phương thức để tìm kiếm SanPhamChiTiet theo ID
    public SanPhamChiTiet findById(Long id) {
        Optional<SanPhamChiTiet> sanPhamChiTiet = sanPhamChiTietRepository.findById(id);
        return sanPhamChiTiet.orElse(null); // Trả về null nếu không tìm thấy
    }
}
