package com.example.banson5s.BanHang.Repository;

import com.example.banson5s.BanHang.Entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepo extends JpaRepository<GioHang, Long> {
    List<GioHang> findByKhachHangId(Long idKhachHang);
    //List<GioHang> findByKhachHangId(Long khachHangId);
}
