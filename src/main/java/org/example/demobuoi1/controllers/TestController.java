package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entities.SanPhamChiTiet;
import org.example.demobuoi1.repositories.asm2.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/testCL")
public class TestController {

    private SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    public void setSanPhamChiTietRepository(SanPhamChiTietRepository sanPhamChiTietRepository) {
        this.sanPhamChiTietRepository = sanPhamChiTietRepository;
    }

    @GetMapping()
    public String getTest(Model model){
        List<SanPhamChiTiet> list = sanPhamChiTietRepository.findAll();
        model.addAttribute("sp" , list);
        return "hello";
    }
}
