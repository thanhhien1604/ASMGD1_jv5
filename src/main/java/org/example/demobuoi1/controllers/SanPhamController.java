package org.example.demobuoi1.controllers;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.repositories.asm2.SanPhamRepository2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Optional;

@RequestMapping("/san-pham")

@Controller
public class SanPhamController {
    private static final Logger log = LoggerFactory.getLogger(SanPhamController.class);
    @Autowired
    private SanPhamRepository2 spRepo;
    @Autowired
    private SanPhamRepository2 sanPhamRepository2;


    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "limit" , defaultValue = "5") int pageSize,
                        @RequestParam(name = "page" , defaultValue = "1") int pageNumber

    ){
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<SanPham> page = spRepo.findAll(p);
        int totalPages = page.getTotalPages();
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("currentPage",pageNumber);
        model.addAttribute("data",page);
        return "san_pham/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") SanPham sanPham) {

        return "san_pham/create";
    }

    @PostMapping("/store")
    public String store( @Valid SanPham sanPham, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",getErrorMessages(bindingResult));
            return "san_pham/create";
        }
        spRepo.save(sanPham);
        return "redirect:/san-pham/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute SanPham sanPham ,
                       @PathVariable("id") Integer id,
                       Model model,
                       HttpSession session)  {
        SanPham sanPhamEdit = this.spRepo.findById(id).get();
        session.setAttribute("id" ,sanPhamEdit.getId());
        log.info("spedit {}" ,sanPhamEdit );
        model.addAttribute("data",sanPhamEdit);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(@Valid SanPham sanPham,
                         BindingResult bindingResult, Model model , HttpSession session) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", getErrorMessages(bindingResult));
            return "san_pham/edit";
        }
        log.info("Product {}" , sanPham);
        spRepo.save(sanPham);
        session.removeAttribute("id");
        return "redirect:/san-pham/index";
    }

    @GetMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false , defaultValue = "") String valueSearch,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SanPham> list= sanPhamRepository2.findByTenContainingIgnoreCase(valueSearch.trim() , pageable);
        model.addAttribute("data", list);

        int totalPages = list.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("isSearching", !valueSearch.isEmpty());
        return "san_pham/index";
    }



//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") Integer id,Model model,
//                         @Valid SanPham sanPham, BindingResult validate) {
//        if(validate.hasErrors()){
//            Map<String,String> errors = new HashMap<String,String>();
//            for(FieldError e : validate.getFieldErrors()) {
//                errors.put(e.getField(),e.getDefaultMessage());
//            }
//            model.addAttribute("errors",errors);
//            model.addAttribute("data",sanPham);
//
//            return "san_pham/edit";
//        }
//        this.sanPhamRepository.update(sanPham);
//        return "redirect:/san-pham/index";
//    }

    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }
//
//    @PostMapping("/tim-kiem")
//    public String timKiem(Model model, @RequestParam(required = false) String valueSearch, @RequestParam(required = false) Integer searchStatus) {
//        List<SanPham> list= sanPhamRepository.findByMaVaStatus(valueSearch, searchStatus);
//        model.addAttribute("data", list);
//        model.addAttribute("searchStatus", searchStatus);
//        model.addAttribute("valueSearch", valueSearch);
//        return "san_pham/index";
//
//    }

}

