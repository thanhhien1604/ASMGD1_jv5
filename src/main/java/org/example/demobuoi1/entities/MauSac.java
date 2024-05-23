package org.example.demobuoi1.entities;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MauSac {
    private Integer id;
    @NotBlank(message = "ma is required")
    private String ma;
    @NotBlank(message = "ten is required")
    private String ten;
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
