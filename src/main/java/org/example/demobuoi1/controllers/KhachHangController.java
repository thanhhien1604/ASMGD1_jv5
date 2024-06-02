package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.KhachHang;
import org.example.demobuoi1.repositories.asm2.KhachHangRepository2;
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
@RequestMapping("/khach-hang")
public class KhachHangController {
   @Autowired
   private KhachHangRepository2 khachHangRepository;
    @GetMapping("/index")
    public String index(Model model) {
        List<KhachHang> list = khachHangRepository.findAll();
        model.addAttribute("data", list);
        return "khach_hang/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") KhachHang khachHang) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
   public String store(KhachHang khachHang) {
        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                       @ModelAttribute("data") KhachHang kh) {
        KhachHang khachHang = khachHangRepository.findById(id).get();
        model.addAttribute("data", khachHang);
        return "khach_hang/edit";
    }

    @PostMapping("/update/{id}")
    public String update( KhachHang khachHang) {
        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }



}
