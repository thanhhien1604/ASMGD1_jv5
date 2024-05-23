package org.example.demobuoi1.controllers;


import org.example.demobuoi1.entities.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    private SanPham sanPham;
    @Qualifier("bean1")
    @GetMapping("hello")
    public String hello() {
        System.out.println(sanPham.getMa());
        System.out.println(sanPham.getTen());
        System.out.println(sanPham.getTrangThai());
        return "hello";
    }
}
