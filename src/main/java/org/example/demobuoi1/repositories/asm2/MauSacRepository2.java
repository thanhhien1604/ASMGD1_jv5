package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository2 extends JpaRepository<MauSac, Integer> {

    Page<MauSac> findByTenContainingIgnoreCase(String valueSearch , Pageable pageable);

    List<MauSac> findAllByTrangThai(int trangThai);
}
