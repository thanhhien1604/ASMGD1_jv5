package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.repositories.asm1.MauSacRepository;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    private MauSacRepository mauSacRepository;

    public MauSacController() {
        this.mauSacRepository = new MauSacRepository();
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(value = "keyword", required = false) String keyword,
                        @RequestParam(value = "page", defaultValue = "0") int page) {
        int pageSize = 2;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<MauSac> colorPage ;
        if (keyword != null && !keyword.isEmpty()) {
            colorPage = mauSacRepository.findByNameContaining(keyword, pageable);
        } else {
            colorPage = mauSacRepository.findAllPage(pageable);
        }
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colorPage.getTotalPages());
        model.addAttribute("totalItems", colorPage.getTotalElements());
        model.addAttribute("data", colorPage.getContent());

        return "mau_sac/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") MauSac mauSac) {
        return "mau_sac/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid  MauSac mauSac,
                        BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String,String> errors = new HashMap<String,String>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",mauSac);

            return "mau_sac/create";
        }
        this.mauSacRepository.create(mauSac);
        return "redirect:/mau-sac/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model,
                        @ModelAttribute("data") MauSac ms){
        MauSac mauSac = this.mauSacRepository.findById(id);
        model.addAttribute("data", mauSac);
        return "mau_sac/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         Model model, @Valid MauSac mauSac, BindingResult validate) {
        if (validate.hasErrors()) {
            Map<String,String> errors = new HashMap<String,String>();
            for(FieldError e : validate.getFieldErrors()) {
                errors.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            model.addAttribute("data",mauSac);

            return "mau_sac/edit";
        }
        this.mauSacRepository.update( mauSac);
        return "redirect:/mau-sac/index";
    }
}
