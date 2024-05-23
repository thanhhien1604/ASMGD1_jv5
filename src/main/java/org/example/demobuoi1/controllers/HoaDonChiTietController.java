package org.example.demobuoi1.controllers;

import org.example.demobuoi1.entities.HoaDonChiTiet;
import org.example.demobuoi1.repositories.asm1.HoaDonChiTietRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    private HoaDonChiTietRepository hoaDonChiTietRepository;
    public HoaDonChiTietController() {
        this.hoaDonChiTietRepository = new HoaDonChiTietRepository();
    }
    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<HoaDonChiTiet> colorPage = hoaDonChiTietRepository.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("data", colorPage.getContent());
        return "hoa_don_chi_tiet/index";
    }
}
