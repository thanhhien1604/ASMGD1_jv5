package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demobuoi1.contants.Status;
import org.example.demobuoi1.entities.KichThuoc;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.entities.SanPhamChiTiet;
import org.example.demobuoi1.repositories.asm2.KichThuocRepository2;
import org.example.demobuoi1.repositories.asm2.MauSacRepository2;
import org.example.demobuoi1.repositories.asm2.SanPhamChiTietRepository;
import org.example.demobuoi1.repositories.asm2.SanPhamRepository2;
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
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/san-pham-chi-tiet")
public class SanPhamChiTietController {

    private final SanPhamChiTietRepository sanPhamChiTietRepository;
    private final SanPhamRepository2 sanPhamRepository;
    private final MauSacRepository2 mauSacRepository;
    private final KichThuocRepository2 kichThuocRepository;


    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "limit", defaultValue = "5") int pageSize,
                        @RequestParam(name = "page", defaultValue = "1") int pageNumber) {
//        List<SanPham> sanPhams = sanPhamRepository.findAll();
//        model.addAttribute("dataSP", sanPhams);

        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<SanPhamChiTiet> page =  sanPhamChiTietRepository.findAll(p);
        int totalPages = page.getTotalPages();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("data", page);
        return "san_pham_chi_tiet/index";
    }


    @GetMapping("create")
    public String create(Model model, @ModelAttribute("data" ) SanPhamChiTiet spct) {

        List<SanPham> listSP = sanPhamRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("dataSP" , listSP);
        List<MauSac> listMS = mauSacRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("listMauSac", listMS);
        List<KichThuoc> listKT = kichThuocRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("listKichThuoc", listKT);
        return "san_pham_chi_tiet/create";
    }
    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }
    @PostMapping("store")
    public String store(Model model, @Valid SanPhamChiTiet sanPhamChiTiet, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", getErrorMessages(bindingResult));
            return "san_pham_chi_tiet/create";
        }

        this.sanPhamChiTietRepository.save(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.sanPhamChiTietRepository.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        SanPhamChiTiet spct = this.sanPhamChiTietRepository.findById(id).get();
        model.addAttribute("data", spct);
        List<SanPham> listSP = sanPhamRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("dataSP" , listSP);
        List<MauSac> listMS = mauSacRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("listMauSac", listMS);
        List<KichThuoc> listKT = kichThuocRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("listKichThuoc", listKT);
        return "san_pham_chi_tiet/edit";
    }
    @PostMapping("update/{id}")
    public String update( SanPhamChiTiet sanPhamChiTiet){
        this.sanPhamChiTietRepository.save(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }

}
