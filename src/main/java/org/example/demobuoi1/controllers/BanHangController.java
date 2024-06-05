package org.example.demobuoi1.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.demobuoi1.contants.Status;
import org.example.demobuoi1.entities.*;
import org.example.demobuoi1.repositories.asm2.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller

public class BanHangController {
    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    private SanPhamRepository2 sanPhamRepository;
    @Autowired
    private MauSacRepository2 mauSacRepository;
    @Autowired
    private KichThuocRepository2 kichThuocRepository;
    @Autowired
    private NhanVienRepository2 nhanVienRepository;

    @GetMapping("/banhang")
    public String sanPhamChiTiet(Model model) {
            List<SanPham> listSP = sanPhamRepository.findAllByTrangThai(Status.ACTIVE);
            List<SanPhamChiTiet> listSPCT = sanPhamChiTietRepository.findAll();
            List<MauSac> listMauSac = mauSacRepository.findAllByTrangThai(Status.ACTIVE);
            List<KichThuoc> listKichThuoc = kichThuocRepository.findAllByTrangThai(Status.ACTIVE);;

            model.addAttribute("data", listMauSac);
            model.addAttribute("data", listKichThuoc);
            model.addAttribute("data", listSP);
            model.addAttribute("data", listSPCT);

        return "ban_hang";
    }

    @PostMapping("/taoHoaDon")
    public String taoHoaDon( HttpSession session){
        String tenNhanVien = (String) session.getAttribute("tenNhanVien");
        if(tenNhanVien!=null){
            HoaDon hoaDon = new HoaDon();
            hoaDon.setNgayMuaHang(new Date());
            NhanVien nhanVien = nhanVienRepository.findAllByTenDangNhap(tenNhanVien);
            hoaDon.setNhanVien(nhanVien);
            hoaDon.setTrangThai(1);
            hoaDon.setNhanVien(nhanVien);
        }


        return "redirect:/banhang";
    }
}
