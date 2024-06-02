package org.example.demobuoi1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "khong duoc de trong ma")
    @Column(name = "Ma")
    private String ma;
    @NotBlank(message = "khong duoc de trong ten")
    @Column(name = "Ten")
    private String ten;
    @Digits(integer = 1, fraction  = 0)
    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "sanPham" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SanPhamChiTiet> SPCTlist;

}
