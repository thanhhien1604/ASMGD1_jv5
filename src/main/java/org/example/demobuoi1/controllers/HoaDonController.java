package org.example.demobuoi1.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.demobuoi1.contants.Status;
import org.example.demobuoi1.entities.HoaDon;
import org.example.demobuoi1.entities.KhachHang;
import org.example.demobuoi1.entities.NhanVien;

import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.repositories.asm2.HoaDonRepository2;
import org.example.demobuoi1.repositories.asm2.KhachHangRepository2;
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

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonRepository2 hoaDonRepository;
    @Autowired
    KhachHangRepository2 khachHangRepository;
    @Autowired
    NhanVienRepository2 nhanVienRepository;

        @GetMapping("/index")
        public String index(Model model,
                            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
                            @RequestParam(name = "limit", defaultValue = "5") int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<HoaDon> pageHoaDon = hoaDonRepository.findAll(pageable);
            model.addAttribute("data", pageHoaDon);
            model.addAttribute("currentPage",pageNumber);
            model.addAttribute("totalPages",pageHoaDon.getTotalPages());
            return "hoa_don/index";
        }

        @GetMapping("/edit/{id}")
        public String edit(@ModelAttribute HoaDon hd,
                           @PathVariable("id") int id,
                           Model model,
                           HttpSession session) {
            HoaDon hoaDon = hoaDonRepository.findById(id).get();
            session.setAttribute("id", hoaDon.getId());
            model.addAttribute("data", hoaDon);
            return "hoa_don/edit";
        }

        @PostMapping("/update/{id}")
        public String update(@Valid HoaDon hoaDon,
                             BindingResult bindingResult,
                             Model model,
                             HttpSession session) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("errors", getErrorMessages(bindingResult));
                return "hoa_don/edit";
            }
            hoaDonRepository.save(hoaDon);
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
