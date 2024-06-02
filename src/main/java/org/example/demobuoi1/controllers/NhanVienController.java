package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.NhanVien;

import org.example.demobuoi1.repositories.asm2.NhanVienRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository2 nhanVienRepository;
    @GetMapping("/index")
    public String index(Model model) {
       List<NhanVien> list = nhanVienRepository.findAll();
       model.addAttribute("data", list);
        return "nhan_vien/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") NhanVien nhanVien) {
        return "nhan_vien/create";
    }

    @PostMapping("/store")
    public String store(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        NhanVien nhanVien = this.nhanVienRepository.findById(id).get();
        model.addAttribute("data", nhanVien);
        return "nhan_vien/edit";
    }

    @PostMapping("/update/{id}")
    public String update(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }


}
