package org.example.demobuoi1.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SanPham {
    private Integer id;
    @NotBlank(message = "khong duoc de trong ma")
    private String ma;
    @NotBlank(message = "khong duoc de trong ten")
    private String ten;
    @Digits(integer = 1, fraction  = 0)
    private int trangThai;
}
