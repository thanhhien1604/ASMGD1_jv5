package org.example.demobuoi1.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "ten is not null")
    @Column(name = "Ten")
    private String ten;
    @NotBlank(message = "ma is not null")
    @Column(name = "Ma")
    private String ma;
    @NotBlank(message = "tenDangNhap is not null")
    @Column(name = "TenDangNhap")
    private String tenDangNhap;
    @NotBlank(message = "matKhau is not null")
    @Column(name = "MatKhau")
    private String matKhau;
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "Quyen")
    private String quyen;

    @OneToMany(mappedBy = "nhanVien" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<HoaDon> HoaDonList;

;

}
