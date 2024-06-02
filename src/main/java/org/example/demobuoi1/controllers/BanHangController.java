//package org.example.demobuoi1.controllers;
//
//import org.example.demobuoi1.entities.*;
//import org.example.demobuoi1.repositories.asm1.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Controller
//
//public class BanHangController {
//    @Autowired
//    private SanPhamChiTietRepository sanPhamChiTietRepository;
//    @Autowired
//    private SanPhamRepository sanPhamRepository;
//    @Autowired
//    private MauSacRepository mauSacRepository;
//    @Autowired
//    private KichThuocRepository kichThuocRepository;
//    @Autowired
//    private NhanVienRepository nhanVienRepository;
//
//    @GetMapping("/banhang")
//    public String sanPhamChiTiet(Model model) {
//            List<SanPham> listSP = sanPhamRepository.getAll();
//            List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.getAll();
//            List<MauSac> listMauSac = mauSacRepository.getAll();
//            List<KichThuoc> listKichThuoc = kichThuocRepository.getAll();
//            Map<Integer, String> tenSanPham = listSP.stream().collect(Collectors.toMap(SanPham::getId, SanPham::getTen));
//            Map<Integer, String> tenMauSac = listMauSac.stream().collect(Collectors.toMap(MauSac::getId, MauSac::getTen));
//            Map<Integer, String> tenKichThuoc = listKichThuoc.stream().collect(Collectors.toMap(KichThuoc::getId, KichThuoc::getTen));
//            model.addAttribute("tenSanPham", tenSanPham);
//            model.addAttribute("tenMauSac", tenMauSac);
//            model.addAttribute("tenKichThuoc", tenKichThuoc);
//            model.addAttribute("dataSP", listSP);
//            model.addAttribute("data", listSPCT);
//
//        return "ban_hang";
//    }
//
//    @PostMapping("/banhang")
//    public String taoHoaDon(){
////        HoaDon hoaDon = new HoaDon();
////
////        hoaDon.setIdNhanVien(nhanVien.getTen());
////        hoaDon.setNgayMuaHang(new Date());
////        hoaDon.setTrangThai(0);
//        return "redirect:/banhang";
//    }
//}
