package org.example.demobuoi1.repositories.asm2;

import org.example.demobuoi1.entities.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository2 extends JpaRepository<KhachHang, Integer> {
}
