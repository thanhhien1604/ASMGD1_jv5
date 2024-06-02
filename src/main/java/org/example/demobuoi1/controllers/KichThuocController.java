package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entities.KichThuoc;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.repositories.asm2.KichThuocRepository2;
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
@RequestMapping("/kich-thuoc")

public class KichThuocController {
    @Autowired
    private KichThuocRepository2 kichThuocRepository;

   @GetMapping("/index")
   public String index(Model model) {
       List<KichThuoc> list = kichThuocRepository.findAll();
       model.addAttribute("data", list);
       return "kich_thuoc/index";
   }

    @GetMapping ("/create")
    public String create() {
        return "kich_thuoc/create";
    }

    @PostMapping("/store")
    public String store(KichThuoc kichThuoc) {
        this.kichThuocRepository.save(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                       @ModelAttribute("data") KichThuoc kt) {
        KichThuoc kichThuoc = this.kichThuocRepository.findById(id).get();
        model.addAttribute("data", kichThuoc);
        return "kich_thuoc/edit";
    }

    @PostMapping("/update/{id}")
    public String update(KichThuoc kichThuoc){
        this.kichThuocRepository.save( kichThuoc);
        return "redirect:/kich-thuoc/index";
    }


}
