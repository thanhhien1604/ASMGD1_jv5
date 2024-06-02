package org.example.demobuoi1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "idHoaDon is required")
    @Column(name = "IdHoaDon")
    private Integer idHoaDon;


    @NotBlank(message = "soLuong is required")
    @Column(name = "SoLuong")
    private Integer soLuong;

    @NotBlank(message = "donGia is required")
    @Column(name = "DonGia")
    private Double donGia;

    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })

    @JoinColumn(name = "idSPCT")
    private SanPhamChiTiet sanPhamChiTiet;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })

    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;

}
