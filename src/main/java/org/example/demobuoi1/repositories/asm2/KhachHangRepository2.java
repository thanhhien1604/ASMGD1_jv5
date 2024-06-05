package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.KhachHang;
import org.example.demobuoi1.entities.KichThuoc;
import org.example.demobuoi1.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository2 extends JpaRepository<KhachHang, Integer> {

    List<KhachHang> findAllByTrangThai(int trangThai);
    Page<KhachHang> findByTenContainingIgnoreCase(String valueSearch, Pageable pageable);
}
