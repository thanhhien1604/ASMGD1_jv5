package org.example.demobuoi1.controllers;


import org.example.demobuoi1.entities.KichThuoc;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.entities.SanPhamChiTiet;
import org.example.demobuoi1.repositories.asm1.KichThuocRepository;
import org.example.demobuoi1.repositories.asm1.MauSacRepository;
import org.example.demobuoi1.repositories.asm1.SanPhamChiTietRepository;
import org.example.demobuoi1.repositories.asm1.SanPhamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/san-pham-chi-tiet")
public class SanPhamChiTietController {
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    private SanPhamRepository sanPhamRepository;
    private MauSacRepository mauSacRepository;
    private KichThuocRepository kichThuocRepository;
    public SanPhamChiTietController() {
        this.sanPhamChiTietRepository = new SanPhamChiTietRepository();
        this.sanPhamRepository = new SanPhamRepository();
        this.mauSacRepository = new MauSacRepository();
        this.kichThuocRepository = new KichThuocRepository();
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "idSanPham", required = false) Integer idSanPham) {

        if (idSanPham != null) {
//            List<SanPham> listSP = sanPhamRepository.getAll();
//            model.addAttribute("dataSP", listSP);
//            List<SanPhamChiTiet> listSPCT =  sanPhamChiTietRepository.findBySanPhamId(idSanPham);
//            model.addAttribute("data", listSPCT);
            List<SanPham> listSP = sanPhamRepository.getAll();
            List<SanPhamChiTiet> listSPCT = (idSanPham != null) ? sanPhamChiTietRepository.findBySanPhamId(idSanPham) : sanPhamChiTietRepository.getAll();
            List<MauSac> listMauSac = mauSacRepository.getAll();
            List<KichThuoc> listKichThuoc = kichThuocRepository.getAll();

            Map<Integer, String> tenSanPham = listSP.stream()
                    .collect(Collectors.toMap(SanPham::getId, SanPham::getTen));
            Map<Integer, String> tenMauSac = listMauSac.stream()
                    .collect(Collectors.toMap(MauSac::getId, MauSac::getTen));
            Map<Integer, String> tenKichThuoc = listKichThuoc.stream()
                    .collect(Collectors.toMap(KichThuoc::getId, KichThuoc::getTen));

            model.addAttribute("tenSanPham", tenSanPham);
            model.addAttribute("tenMauSac", tenMauSac);
            model.addAttribute("tenKichThuoc", tenKichThuoc);
            model.addAttribute("dataSP", listSP);
            model.addAttribute("data", listSPCT);
            model.addAttribute("idSanPham", idSanPham);

            return "san_pham_chi_tiet/index";

        }else{
//            List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.getAll();
//            model.addAttribute("data", listSPCT);
//
//            List<SanPham> listSP = sanPhamRepository.getAll();
//            model.addAttribute("dataSP", listSP);
            List<SanPham> listSP = sanPhamRepository.getAll();
            List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.getAll();
            List<MauSac> listMauSac = mauSacRepository.getAll();
            List<KichThuoc> listKichThuoc = kichThuocRepository.getAll();
            Map<Integer, String> tenSanPham = listSP.stream().collect(Collectors.toMap(SanPham::getId, SanPham::getTen));
            Map<Integer, String> tenMauSac = listMauSac.stream().collect(Collectors.toMap(MauSac::getId, MauSac::getTen));
            Map<Integer, String> tenKichThuoc = listKichThuoc.stream().collect(Collectors.toMap(KichThuoc::getId, KichThuoc::getTen));
            model.addAttribute("tenSanPham", tenSanPham);
            model.addAttribute("tenMauSac", tenMauSac);
            model.addAttribute("tenKichThuoc", tenKichThuoc);
            model.addAttribute("dataSP", listSP);
            model.addAttribute("data", listSPCT);
            return "san_pham_chi_tiet/index";
        }

    }


//    @GetMapping("/index")
//    public String index(Model model , @RequestParam("idSanPham") Integer idSanPham) {
//        List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.getAll();
//        model.addAttribute("data",listSPCT);
//        List<SanPham> listSP = sanPhamRepository.getAll();
//        model.addAttribute("dataSP",listSP);
//        if(idSanPham!=null){
//            this.sanPhamChiTietRepository.findBySanPhamId(idSanPham);
//        }
//
//
//        return "san_pham_chi_tiet/index";
//    }

    @GetMapping("create")
    public String create(Model model){
        List<KichThuoc> listKT = kichThuocRepository.getAll();
        List<MauSac> listMS = mauSacRepository.getAll();
        List<SanPham> listSP = sanPhamRepository.getAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("dataSP", listSP);
        return "san_pham_chi_tiet/create";
    }
    @PostMapping("store")
    public String store(Model model, SanPhamChiTiet sanPhamChiTiet){
        List<KichThuoc> listKT = kichThuocRepository.getAll();
        List<MauSac> listMS = mauSacRepository.getAll();
        List<SanPham> listSP = sanPhamRepository.getAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("dataSP", listSP);
        this.sanPhamChiTietRepository.create(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.sanPhamChiTietRepository.deleteById(id);
        return "redirect:/san-pham-chi-tiet/index";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPhamChiTiet spct = this.sanPhamChiTietRepository.findById(id);
        List<KichThuoc> listKT = kichThuocRepository.getAll();
        List<MauSac> listMS = mauSacRepository.getAll();
        List<SanPham> listSP = sanPhamRepository.getAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("dataSP", listSP);
        model.addAttribute("data", spct);
        return "san_pham_chi_tiet/edit";
    }
    @PostMapping("update/{id}")
    public String update(Model model, SanPhamChiTiet sanPhamChiTiet){
        List<KichThuoc> listKT = kichThuocRepository.getAll();
        List<MauSac> listMS = mauSacRepository.getAll();
        List<SanPham> listSP = sanPhamRepository.getAll();
        model.addAttribute("listKichThuoc", listKT);
        model.addAttribute("listMauSac", listMS);
        model.addAttribute("listSanPham", listSP);
        this.sanPhamChiTietRepository.update(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/index";
    }






}
