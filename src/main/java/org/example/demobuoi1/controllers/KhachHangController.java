package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.KhachHang;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.repositories.asm1.KhachHangRepository;
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
    private KhachHangRepository khachHangRepository;
    public KhachHangController() {
        this.khachHangRepository = new KhachHangRepository();
    }
    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<KhachHang> colorPage = khachHangRepository.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("data", colorPage.getContent());
        return "khach_hang/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") KhachHang khachHang) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid KhachHang khachHang,
                        BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String,String> errors = new HashMap<String,String>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",khachHang);
            return "khach_hang/create";
        }
        khachHangRepository.create(khachHang);
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
        KhachHang khachHang = khachHangRepository.findById(id);
        model.addAttribute("data", khachHang);
        return "khach_hang/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model,
                         @Valid KhachHang khachHang, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String,String> errors = new HashMap<String,String>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",khachHang);
            return "khach_hang/edit";
        }
        this.khachHangRepository.update(khachHang);
        return "redirect:/khach-hang/index";
    }

}
