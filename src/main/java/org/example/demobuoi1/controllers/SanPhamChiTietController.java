package org.example.demobuoi1.controllers;


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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String index(Model model) {

        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.findAll();
        model.addAttribute("data", listSPCT);
        return "san_pham_chi_tiet/index";
    }


    @GetMapping("create")
    public String create(Model model) {
        List<SanPham> listSP = sanPhamRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("dataSP" , listSP);
        List<MauSac> listMS = mauSacRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("listMauSac", listMS);
        List<KichThuoc> listKT = kichThuocRepository.findAllByTrangThai(Status.ACTIVE);
        model.addAttribute("listKichThuoc", listKT);
        return "san_pham_chi_tiet/create";
    }
    @PostMapping("store")
    public String store( SanPhamChiTiet sanPhamChiTiet){

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
        return "san_pham_chi_tiet/edit";
    }
    @PostMapping("update/{id}")
    public String update( SanPhamChiTiet sanPhamChiTiet){
        this.sanPhamChiTietRepository.save(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }

}
