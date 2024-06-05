package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocRepository2 extends JpaRepository<KichThuoc, Integer> {
    Page<KichThuoc> findByTenContainingIgnoreCase(String valueSearch, Pageable pageable);
    List<KichThuoc> findAllByTrangThai(int trangThai);
}
