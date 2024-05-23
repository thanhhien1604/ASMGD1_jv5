package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.NhanVien;
import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.repositories.asm1.NhanVienRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

    private NhanVienRepository nhanVienRepository;
    public NhanVienController() {
        this.nhanVienRepository = new NhanVienRepository();
    }
    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<NhanVien> colorPage = nhanVienRepository.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("data", colorPage.getContent());
        return "nhan_vien/index";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute("data") NhanVien nhanVien) {
        return "nhan_vien/create";
    }
    @RequestMapping("/store")
    public String store(Model model,
                        @Valid NhanVien nhanVien, BindingResult  validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<String, String>();
            for(FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", nhanVien);

            return "nhan_vien/create";
        }
        this.nhanVienRepository.create(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                       @ModelAttribute("data") NhanVien nv) {

        NhanVien nhanVien = this.nhanVienRepository.findById(id);
        model.addAttribute("data", nhanVien);
        return "nhan_vien/edit";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model,
                         @Valid NhanVien nhanVien, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String, String> errors = new HashMap<String, String>();
            for(FieldError e: validate.getFieldErrors()){
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", nhanVien);

            return "nhan_vien/edit";
        }
        this.nhanVienRepository.update(nhanVien);
        return "redirect:/nhan-vien/index";
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nhanVienRepository.deleteById(id);
        return "redirect:/nhan_vien/delete";
    }
}
