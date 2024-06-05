package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NhanVienRepository2 extends JpaRepository<NhanVien, Integer> {
    Page<NhanVien> findByTenContainingIgnoreCase(String valueSearch, Pageable pageable);
    NhanVien  findAllByTenDangNhap(String tenDangNhap);

    List<NhanVien> findAllByTrangThai(int trangThai);
}
