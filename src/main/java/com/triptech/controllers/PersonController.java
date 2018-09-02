package com.triptech.controllers;

import com.triptech.entities.Person;
import com.triptech.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;


    @GetMapping("FirstName")
    @ResponseBody  //ha vissza akarok térni stringgel vagy JSON-osítva
    public String getFirstName(){
       return personRepository.findAll().get(0).getFirstName();
    }

    @GetMapping("personList") //visszatérési érték alapján egy view resolvert keres (template nevet)
    public String getPersonList(Model model){
        model.addAttribute("persons",personRepository.findAll());
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("savePerson")
    public String savePerson(@ModelAttribute Person person, Model model){
        personRepository.save(person);
        model.addAttribute("persons", personRepository.findAll()); //a model a kommunikációs csatorna a html felé
        model.addAttribute("person", new Person());
        return "person";
    }

}
