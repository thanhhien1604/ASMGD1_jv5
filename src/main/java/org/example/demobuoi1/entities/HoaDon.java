package org.example.demobuoi1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "ngay mua hang is required")
    @Column(name = "ngayMuaHang")
    private Date ngayMuaHang;
    @Digits(integer = 0, fraction = 1)
    @Column(name = "trangThai")
    private int trangThai;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "idNV")
    private NhanVien nhanVien;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "idKH")
    private KhachHang khachHang;


    @OneToMany(mappedBy = "hoaDon" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<HoaDonChiTiet> HDCTList;

}
