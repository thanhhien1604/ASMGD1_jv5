package org.example.demobuoi1.controllers;


import jakarta.validation.Valid;
import org.example.demobuoi1.entities.MauSac;
import org.example.demobuoi1.repositories.asm2.MauSacRepository2;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacRepository2 mauSacRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "1") int pageNumber,
                        @RequestParam(value = "limit", defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<MauSac> pageMauSac = mauSacRepository.findAll(pageable);
        model.addAttribute("data", pageMauSac);
        int totalPages = pageMauSac.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage",pageNumber);
        return "mau_sac/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") MauSac mauSac) {
        return "mau_sac/create";
    }

    @PostMapping("/store")
    public String store(@Valid MauSac mauSac, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
        model.addAttribute("errors", getErrorMessages(bindingResult));
        return "mau_sac/create";
    }
        this.mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        MauSac mauSac = this.mauSacRepository.findById(id).get();
        model.addAttribute("data", mauSac);
        return "mau_sac/edit";
    }

    @PostMapping("/update/{id}")
    public String update(MauSac mauSac) {
        this.mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/index";
    }
    public  static Map<String , String> getErrorMessages(BindingResult bindingResult){
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }


    @GetMapping("/tim-kiem")
    public String timKiem(Model model, @RequestParam(required = false , defaultValue = "") String valueSearch,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MauSac> list= mauSacRepository.findByTenContainingIgnoreCase(valueSearch.trim() , pageable);
        model.addAttribute("data", list);

        int totalPages = list.getTotalPages();
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage",page);
        model.addAttribute("valueSearch",valueSearch);
        model.addAttribute("isSearching", !valueSearch.isEmpty());
        return "mau_sac/index";
    }
}
