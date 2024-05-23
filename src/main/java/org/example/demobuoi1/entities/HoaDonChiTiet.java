package org.example.demobuoi1.entities;

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

public class HoaDonChiTiet {
    private Integer id;
    @NotBlank(message = "idHoaDon is required")
    private Integer idHoaDon;
    @NotBlank(message = "idSanPhamChiTiet is required")
    private Integer idSanPhamChiTiet;
    @NotBlank(message = "soLuong is required")
    private Integer soLuong;
    @NotBlank(message = "donGia is required")
    private Double donGia;
    @Digits(integer = 1, fraction = 0)
    private int trangThai;

}
