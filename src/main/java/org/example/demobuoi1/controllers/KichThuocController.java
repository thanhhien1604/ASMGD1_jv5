package org.example.demobuoi1.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.demobuoi1.entities.KichThuoc;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.entities.NhanVien;
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
   public String index(Model model,
                       @RequestParam(value = "page", defaultValue = "0") int pageNumber,
                       @RequestParam(value = "limit", defaultValue = "5") int pageSize) {
       Pageable pageable = PageRequest.of(pageNumber, pageSize);
       Page<KichThuoc> pageKichThuoc = this.kichThuocRepository.findAll(pageable);
       model.addAttribute("data", pageKichThuoc);
       model.addAttribute("currentPage", pageNumber);
       int totalPages = pageKichThuoc.getTotalPages();
       model.addAttribute("totalPages", totalPages);
       return "kich_thuoc/index";
   }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") KichThuoc kichThuoc) {
        return "kich_thuoc/create";
    }

    @PostMapping("/store")
    public String store(@Valid KichThuoc kichThuoc, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            return "kich_thuoc/create";
        }
        this.kichThuocRepository.save(kichThuoc);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,
                       Model model,
                       @ModelAttribute("data") KichThuoc kt,
                       HttpSession session) {
        KichThuoc kichThuoc = this.kichThuocRepository.findById(id).get();
        session.setAttribute("id", kichThuoc.getId());
        model.addAttribute("data", kichThuoc);
        return "kich_thuoc/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid KichThuoc kichThuoc,
                         BindingResult bindingResult,
                         Model model,
                         HttpSession session) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", getErrorMessages(bindingResult));
            return "kich_thuoc/edit";
        }
        this.kichThuocRepository.save( kichThuoc);
        session.removeAttribute("id");
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false , defaultValue = "") String valueSearch,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KichThuoc> list= kichThuocRepository.findByTenContainingIgnoreCase(valueSearch.trim() , pageable);
        model.addAttribute("data", list);

        int totalPages = list.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("isSearching", !valueSearch.isEmpty());
        return "kich_thuoc/index";
    }

    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }


}
