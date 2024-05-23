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
public class KichThuoc {

    private Integer id;
    @NotBlank(message = "ma requires not null")
    private String ma;
    @NotBlank(message = "ten requires not null")
    private String ten;
    @Digits(integer = 1, fraction = 0)
    private int trangThai;
}
