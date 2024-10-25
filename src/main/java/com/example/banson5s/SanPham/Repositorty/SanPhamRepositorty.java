package com.example.banson5s.SanPham.Repositorty;

import com.example.banson5s.SanPham.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepositorty extends JpaRepository<SanPham, Integer> {
}
