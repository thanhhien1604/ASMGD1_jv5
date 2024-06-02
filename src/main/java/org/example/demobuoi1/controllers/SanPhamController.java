package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.repositories.asm2.SanPhamRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/san-pham")

@Controller
public class SanPhamController {
    @Autowired
    private SanPhamRepository2 spRepo;


    @GetMapping("/index")
    public String index(Model model){
        List<SanPham> listSP = spRepo.findAllByOrderByIdDesc();

        model.addAttribute("data",listSP);
        return "san_pham/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") SanPham sanPham) {

        return "san_pham/create";
    }

    @PostMapping("/store")
    public String store( SanPham sanPham) {
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
    public String edit(@PathVariable("id") Integer id, Model model)  {
        SanPham sanPham = this.spRepo.findById(id).get();
        model.addAttribute("data",sanPham);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(SanPham sanPham){
       spRepo.save(sanPham);
        return "redirect:/san-pham/index";
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

//    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
//        Map<String, String> errors = new HashMap<>();
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//        return errors;
//    }
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

