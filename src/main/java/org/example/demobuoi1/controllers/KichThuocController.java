package org.example.demobuoi1.controllers;

import jakarta.validation.Valid;
import org.example.demobuoi1.entities.KichThuoc;
import org.example.demobuoi1.repositories.asm1.KichThuocRepository;
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
    private KichThuocRepository kichThuocRepository;
    public KichThuocController() {
        this.kichThuocRepository = new KichThuocRepository();
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<KichThuoc> colorPage = kichThuocRepository.findAllPage(pageable);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("data", colorPage.getContent());
        return "kich_thuoc/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") KichThuoc kichThuoc) {
        return "kich_thuoc/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid KichThuoc kichThuoc,
                        BindingResult validate) {
        if (validate.hasErrors() ) {
            Map<String, String> errors = new HashMap<String, String>();
            for(FieldError e: validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("data", kichThuoc);
            return "kich_thuoc/create";
        }
        this.kichThuocRepository.create(kichThuoc);
        return "redirect:/kich-thuoc/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.kichThuocRepository.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                       @ModelAttribute("data") KichThuoc kt) {
        KichThuoc kichThuoc = this.kichThuocRepository.findById(id);
        model.addAttribute("data", kichThuoc);
        return "kich_thuoc/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model,
                         @Valid KichThuoc kichThuoc, BindingResult validate) {
        if (validate.hasErrors() ) {
            Map<String, String> errors = new HashMap<String, String>();
            for(FieldError e: validate.getFieldErrors()) {
                errors.put(e.getField(), e.getDefaultMessage());
            }
            model.addAttribute("data", kichThuoc);
            model.addAttribute("errors", errors);

            return "kich_thuoc/edit";
        }
        this.kichThuocRepository.update( kichThuoc);
        return "redirect:/kich-thuoc/index";
    }
}
