package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entities.HoaDon;
import org.example.demobuoi1.entities.KhachHang;
import org.example.demobuoi1.entities.NhanVien;

import org.example.demobuoi1.repositories.asm2.HoaDonRepository2;
import org.example.demobuoi1.repositories.asm2.KhachHangRepository2;
import org.example.demobuoi1.repositories.asm2.NhanVienRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonRepository2 hoaDonRepository;

        @GetMapping("/index")
        public String index(Model model) {
            List<HoaDon> listHoaDon = hoaDonRepository.findAll();
            model.addAttribute("data",listHoaDon);
            return "hoa_don/index";
        }


}
