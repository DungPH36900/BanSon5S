package com.example.banson5s.BanHang.Repository;

import com.example.banson5s.BanHang.Entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {
    List<HoaDon> findByTrangThai(Integer trangThai);
    @Query("SELECT h FROM HoaDon h WHERE h.trangThai = 0")
    List<HoaDon> findByTrangThai(int trangThai);

}
