package com.triptech.controllers;

import com.triptech.entities.Customer;
import com.triptech.entities.Person;
import com.triptech.repositories.CustomerRepository;
import com.triptech.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@ControllerAdvice
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("FirstName")
    @ResponseBody  //ha vissza akarok térni stringgel vagy JSON-osítva
    public String getFirstName(){
       return personRepository.findAll().get(0).getFirstName();
    }

    @GetMapping("customerList") //visszatérési érték alapján egy view resolvert keres (template nevet)
    public String getCustomerList(Model model){
        model.addAttribute("customers",customerRepository.findAll());
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    /*
    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer, Model model){


        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll()); //a model a kommunikációs csatorna a html felé
        model.addAttribute("customer", new Customer());
        return "customer";
    }
*/

    private Map<Long, Customer> customerMap = new HashMap<>();

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String submit(
            @ModelAttribute("customer") Customer customer,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }else {
            model.addAttribute("firstName", customer.getFirstName());
            model.addAttribute("lastName", customer.getLastName());
            model.addAttribute("birthDate", customer.getBirthDate());
            model.addAttribute("idNumber",customer.getIdNumber());

            customerMap.put(customer.getId(), customer);
            customerRepository.save(customer);
            model.addAttribute("customers", customerRepository.findAll()); //a model a kommunikációs csatorna a html felé
            model.addAttribute("customer", new Customer());
            return "customer";
        }
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome!");
    }
}
