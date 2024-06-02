package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entities.HoaDonChiTiet;
import org.example.demobuoi1.repositories.asm2.HoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;


    @GetMapping("/index")
    public String index(Model  model) {
        List<HoaDonChiTiet> list = hoaDonChiTietRepository.findAll();
        model.addAttribute("data", list);
        return "hoa_don_chi_tiet/index";
    }

}
