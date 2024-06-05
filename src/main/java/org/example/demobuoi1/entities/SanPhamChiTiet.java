package org.example.demobuoi1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotBlank(message = "maSPCT is required")
    @Column(name = "MaSPCT")
    private String maSPCT;
    @NotNull(message = "so luong khong duoc de trong")
    @Min(value =1, message = "soluong >0")
    @Column(name = "SoLuong")
    private Integer soLuong;
    @NotNull(message = "don gia is required")
    @Positive(message = "don gia la so duong")
    @Column(name = "DonGia")
    private Float donGia;
    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "IdKichThuoc")
    private KichThuoc kichThuoc;

    @OneToMany(mappedBy = "sanPhamChiTiet" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<HoaDonChiTiet> HDCTList;


}
