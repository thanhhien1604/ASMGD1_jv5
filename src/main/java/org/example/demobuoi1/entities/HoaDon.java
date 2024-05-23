package org.example.demobuoi1.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class HoaDon {
    private Integer id;
    private Integer idNhanVien;
    private Integer idKhachHang;
    @NotBlank(message = "ngay mua hang is required")
    private Date ngayMuaHang;
    @Digits(integer = 0, fraction = 1)
    private int trangThai;
}
