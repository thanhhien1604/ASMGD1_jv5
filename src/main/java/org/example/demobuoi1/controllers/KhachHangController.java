package org.example.demobuoi1.controllers;


import jakarta.servlet.http.HttpSession;
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
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KhachHang> pageKH = khachHangRepository.findAll(pageable);
        model.addAttribute("data", pageKH);
        model.addAttribute("currentPage", page);
        int totalPages = pageKH.getTotalPages();
        model.addAttribute("totalPages",totalPages);
        return "khach_hang/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") KhachHang khachHang) {
        return "khach_hang/create";
    }

    @PostMapping("/store")
   public String store(@Valid KhachHang khachHang, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            return "khach_hang/create";
        }
        this.khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,
                       Model model,
                       @ModelAttribute KhachHang kh,
                       HttpSession session) {
        KhachHang khachHang = khachHangRepository.findById(id).get();
        session.setAttribute("id", khachHang.getId());
        model.addAttribute("data", khachHang);
        return "khach_hang/edit";
    }

    @PostMapping("/update/{id}")
    public String update( @Valid KhachHang khachHang,
                          BindingResult bindingResult,
                          Model model,
                          HttpSession session) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", getErrorMessages(bindingResult));
            return "khach_hang/edit";
        }
        this.khachHangRepository.save(khachHang);
        session.removeAttribute("id");
        
        return "redirect:/khach-hang/index";
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
        Page<KhachHang> list= khachHangRepository.findByTenContainingIgnoreCase(valueSearch.trim() , pageable);
        model.addAttribute("data", list);

        int totalPages = list.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("isSearching", !valueSearch.isEmpty());
        return "khach_hang/index";
    }



}
