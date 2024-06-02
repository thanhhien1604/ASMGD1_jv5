package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository2 extends JpaRepository<MauSac, Integer> {

    List<MauSac> findAllByTrangThai(int trangThai);
}
