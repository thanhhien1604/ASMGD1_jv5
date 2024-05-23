package org.example.demobuoi1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamChiTiet {
    private Integer id;
    private Integer idMauSac;
    private Integer idKichThuoc;
    private Integer idSanPham;
    private String maSPCT;
    private Integer soLuong;
    private Double donGia;
    private int trangThai;

}
