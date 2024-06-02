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
    public String index(Model model) {
        List<MauSac> list = mauSacRepository.findAll();
        model.addAttribute("data", list);
        return "mau_sac/index";
    }

    @GetMapping ("/create")
    public String create(@ModelAttribute("data") MauSac mauSac) {
        return "mau_sac/create";
    }

    @PostMapping("/store")
    public String store( MauSac mauSac) {

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

//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") Integer id,
//                         Model model, @Valid MauSac mauSac, BindingResult validate) {
//        if (validate.hasErrors()) {
//            Map<String,String> errors = new HashMap<String,String>();
//            for(FieldError e : validate.getFieldErrors()) {
//                errors.put(e.getField(),e.getDefaultMessage());
//            }
//            model.addAttribute("errors",errors);
//            model.addAttribute("data",mauSac);
//
//            return "mau_sac/edit";
//        }
//        this.mauSacRepository.save( mauSac);
//        return "redirect:/mau-sac/index";
//    }

//    @PostMapping("/tim-kiem")
//    public String timKiem(Model model, @RequestParam(required = false) String valueSearch, @RequestParam(required = false) Integer searchStatus) {
//        List<MauSac> list= mauSacRepository.findByMaVaStatus(valueSearch, searchStatus);
//        model.addAttribute("data", list);
//        model.addAttribute("searchStatus", searchStatus);
//        model.addAttribute("valueSearch", valueSearch);
//        return "mau_sac/index";
//
//    }
}
