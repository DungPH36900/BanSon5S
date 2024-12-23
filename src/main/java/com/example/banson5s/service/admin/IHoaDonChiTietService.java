package com.example.banson5s.service.admin;

import com.example.banson5s.entity.admin.HoaDonChiTiet;
import com.example.banson5s.entity.admin.IInvoiceItem;
import com.example.banson5s.service.common.IBaseService;

import java.util.List;
import java.util.Optional;

public interface IHoaDonChiTietService extends IBaseService<HoaDonChiTiet,Long> {

    List<IInvoiceItem> getLstIInvoiceItems(Long idHoaDon);

    List<HoaDonChiTiet> findLstHdctByHd(Long idHoaDon);

    Optional<HoaDonChiTiet> findHoaDonChiTietByHdAndSanPham(Long idHoaDon, Long idSanPham);
}
