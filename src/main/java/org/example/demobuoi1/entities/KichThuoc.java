package org.example.demobuoi1.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "KichThuoc")
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "ma requires not null")
    @Column(name = "Ma")
    private String ma;
    @NotBlank(message = "ten requires not null")
    @Column(name = "Ten")
    private String ten;
    @Digits(integer = 1, fraction = 0)
    @Column(name = "trangThai")
    private int trangThai;


    @OneToMany(mappedBy = "kichThuoc" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SanPhamChiTiet> SPCTlist;

}
