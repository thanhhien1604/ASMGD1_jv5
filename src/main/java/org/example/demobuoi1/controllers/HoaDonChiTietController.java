package org.example.demobuoi1.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.demobuoi1.entities.HoaDon;
import org.example.demobuoi1.entities.HoaDonChiTiet;
import org.example.demobuoi1.repositories.asm2.HoaDonChiTietRepository;
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
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;


    @GetMapping("/index")
    public String index(Model  model,
                        @RequestParam(name = "limit", defaultValue = "5") int pageSize,
                        @RequestParam(name = "page", defaultValue = "0") int pageNumber){
        Pageable p = PageRequest.of(pageNumber,pageSize);
        Page<HoaDonChiTiet> page = hoaDonChiTietRepository.findAll(p);
        model.addAttribute("data", page);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        return "hoa_don_chi_tiet/index";
    }


    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute HoaDonChiTiet hdct,
                       @PathVariable("id") int id,
                       Model model,
                       HttpSession session) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id).get();
        session.setAttribute("id", hoaDonChiTiet.getId());
        model.addAttribute("data", hoaDonChiTiet);
        return "hoa_don_chi_tiet/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid HoaDonChiTiet hoaDonChiTiet,
                         BindingResult bindingResult,
                         Model model,
                         HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", getErrorMessages(bindingResult));
            return "hoa_don_chi_tiet/edit";
        }
        hoaDonChiTietRepository.save(hoaDonChiTiet);
        session.removeAttribute("id");
        return "redirect:/hoa-don/index";

    }

    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }
}
