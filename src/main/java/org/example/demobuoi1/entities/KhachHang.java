package org.example.demobuoi1.entities;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



public class KhachHang {
    private Integer id;
    @NotBlank(message = "ma is required")
    private String ma;
    @NotBlank(message = "ten is required")
    private String ten;
    @Size(min = 8, max = 10)
    private String sdt;
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
