package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SanPhamRepository2 extends JpaRepository<SanPham,Integer> {
    List<SanPham> findAllByOrderByIdDesc();
    List<SanPham> findAllByTrangThai(int trangThai);
}
