package com.example.banson5s.BanHang.Service;

import com.example.banson5s.BanHang.Entity.GioHang;
import com.example.banson5s.BanHang.Repository.GioHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangService {
    @Autowired
    private GioHangRepo gioHangRepository;
//    @Autowired
//    private SanPhamChiTietService sanPhamChiTietService;
//
//    public void addToCart(GioHang gioHang) {
//        Optional<GioHang> existingGioHang = gioHangRepository.findById(gioHang.getId());
//        if (existingGioHang.isPresent()) {
//            GioHang currentGioHang = existingGioHang.get();
//            currentGioHang.setSoLuong(currentGioHang.getSoLuong() + gioHang.getSoLuong());
//            currentGioHang.setTongTien(currentGioHang.getTongTien() + gioHang.getTongTien());
//            gioHangRepository.save(currentGioHang);
//        } else {
//            gioHangRepository.save(gioHang);
//        }
//    }
//
//    public List<GioHang> getAllGioHangs(Long idKhachHang) {
//        return gioHangRepository.findByKhachHangId(idKhachHang);
//    }

    public List<GioHang> getAllGioHangs() {
        return gioHangRepository.findAll();
    }

    public void addToCart(GioHang gioHang) {
        gioHangRepository.save(gioHang);
    }
}
