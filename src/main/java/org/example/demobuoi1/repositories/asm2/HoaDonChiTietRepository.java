package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.HoaDonChiTiet;
import org.example.demobuoi1.entities.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
//    Page<HoaDonChiTiet> findByTenContainingIgnoreCase(String valueSearch, Pageable pageable);
}
