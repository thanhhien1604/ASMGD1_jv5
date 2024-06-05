package org.example.demobuoi1.controllers;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.demobuoi1.entities.MauSac;
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
    public String index(Model model,
                        @RequestParam(value = "limit", defaultValue = "5") int pageSize,
                        @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<NhanVien> page = this.nhanVienRepository.findAll(pageable);
        int totalPages = page.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("data", page);
        return "nhan_vien/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") NhanVien nhanVien) {
        return "nhan_vien/create";
    }

    @PostMapping("/store")
    public String store(@Valid NhanVien nhanVien, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            return "nhan_vien/create";
        }
        this.nhanVienRepository.save(nhanVien);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute NhanVien nhanVien,@PathVariable("id") Integer id, Model model, HttpSession session) {
        NhanVien nhanVienEdit = this.nhanVienRepository.findById(id).get();
        session.setAttribute("id", nhanVienEdit.getId());
        model.addAttribute("data", nhanVienEdit);
        return "nhan_vien/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid NhanVien nhanVien, BindingResult bindingResult,
                         Model model, HttpSession session) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            return "nhan_vien/edit";
        }
        nhanVienRepository.save(nhanVien);
        session.removeAttribute("id");
        return "redirect:/nhan-vien/index";
    }

    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }

    @GetMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false , defaultValue = "") String valueSearch,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<NhanVien> list= nhanVienRepository.findByTenContainingIgnoreCase(valueSearch.trim() , pageable);
        model.addAttribute("data", list);

        int totalPages = list.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("isSearching", !valueSearch.isEmpty());
        return "nhan_vien/index";
    }


}
