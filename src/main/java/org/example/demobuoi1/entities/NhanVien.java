package org.example.demobuoi1.entities;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NhanVien {
    private Integer id;
    @NotBlank(message = "ten is not null")
    private String ten;
    @NotBlank(message = "ma is not null")
    private String ma;
    @NotBlank(message = "tenDangNhap is not null")
    private String tenDangNhap;
    @NotBlank(message = "matKhau is not null")
    private String matKhau;
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
    private String quyen;

}
