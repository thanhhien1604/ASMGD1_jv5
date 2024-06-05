package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.HoaDon;
import org.example.demobuoi1.entities.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository2 extends JpaRepository<HoaDon, Integer> {
//    Page<HoaDon> findByTenContainingIgnoreCase(String valueSearch, Pageable pageable);

}
