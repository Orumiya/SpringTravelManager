package com.triptech.controllers;

import com.triptech.entities.Office;
import com.triptech.repositories.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OfficeController {
    @Autowired
    OfficeRepository officeRepository;

    @GetMapping("first")
    @ResponseBody
    public String getOfficeName(){
        return officeRepository.findAll().get(0).getOfficeName();
    }

    @GetMapping("officeList")
    public String getOfficeList(Model model){
        model.addAttribute("offices",officeRepository.findAll());
        model.addAttribute("office", new Office());
        return "office";
    }

    @PostMapping("saveOffice")
    public String saveOffice(@ModelAttribute Office office, Model model){
        officeRepository.save(office);
        model.addAttribute("offices", officeRepository.findAll());
        model.addAttribute("office", new Office());
        return "office";
    }
}
