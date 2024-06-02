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
@Table(name = "MauSac")
@Entity
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "ma is required")
    @Column(name = "Ma")
    private String ma;
    @NotBlank(message = "ten is required")
    @Column(name = "Ten")
    private String ten;
    @Digits(integer = 1, fraction = 0)
    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "mauSac" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SanPhamChiTiet> SPCTlist;

}
