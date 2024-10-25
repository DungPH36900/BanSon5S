package com.example.banson5s.SanPham.Repositorty;

import com.example.banson5s.SanPham.Entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuRepositorty extends JpaRepository<ThuongHieu,Integer> {
}
