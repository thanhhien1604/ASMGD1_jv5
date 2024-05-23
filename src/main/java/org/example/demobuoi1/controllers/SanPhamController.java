package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.SanPham;
import org.example.demobuoi1.repositories.asm1.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/san-pham")

@Controller
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;


    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<SanPham> colorPage = sanPhamRepository.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("data", colorPage.getContent());
        return "san_pham/index";
    }
    @GetMapping ("/create")
    public String create(@ModelAttribute("data") SanPham sanPham) {

        return "san_pham/create";
    }

//    @PostMapping("/store")
//    public String store(
//            @RequestParam("ma") String maSP,
//            @RequestParam("ten") String tenSP,
//            @RequestParam("trangThai") String trangThaiSP
//    ) {
//        System.out.println("SanPhamController@store");
//        System.out.println(maSP);
//        System.out.println(tenSP);
//        System.out.println(trangThaiSP);
//        return "redirect:/san-pham/create";
//    }
    @PostMapping("/store")
    public String store(Model model,
                        @Valid SanPham sanPham, BindingResult validate) {
        if(sanPhamRepository.exitByMa(sanPham.getMa())){
            validate.rejectValue("ma" , "ma" , "San Pham Da Ton Tai Ma Nay");
        }
        if(validate.hasErrors()){
            model.addAttribute("errors",getErrorMessages(validate));
            model.addAttribute("data",sanPham);
            return "san_pham/create";
        }
        sanPhamRepository.create(sanPham);
        return "redirect:/san-pham/index";
    }

    // query string
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        this.sanPhamRepository.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                       @ModelAttribute("data") SanPham sp) {
        SanPham sanPham = this.sanPhamRepository.findById(id);
        model.addAttribute("data",sanPham);
        return "san_pham/edit";
    }



    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model,
                         @Valid SanPham sanPham, BindingResult validate) {
        if(validate.hasErrors()){
            Map<String,String> errors = new HashMap<String,String>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",sanPham);

            return "san_pham/edit";
        }
        this.sanPhamRepository.update(sanPham);
        return "redirect:/san-pham/index";
    }

    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }

}

