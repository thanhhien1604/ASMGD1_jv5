package org.example.demobuoi1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SanPhamChiTiet")
@Entity
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "maSPCT")
    private String maSPCT;
    @Column(name = "soLuong")
    private Integer soLuong;
    @Column(name = "donGia")
    private Float donGia;
    @Column(name = "trangThai")
    private int trangThai;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "idSanPham")
    private SanPham sanPham;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "idKichThuoc")
    private KichThuoc kichThuoc;

    @OneToMany(mappedBy = "sanPhamChiTiet" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<HoaDonChiTiet> HDCTList;


}
