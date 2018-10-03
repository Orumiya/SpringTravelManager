package com.triptech.controllers;

import com.triptech.entities.Customer;
import com.triptech.entities.Person;
import com.triptech.entities.TravelGuide;
import com.triptech.repositories.CustomerRepository;
import com.triptech.repositories.PersonRepository;
import com.triptech.repositories.TravelGuideRepository;
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

    @Autowired
    TravelGuideRepository travelGuideRepository;

    @GetMapping("FirstName")
    @ResponseBody  //ha vissza akarok térni stringgel vagy JSON-osítva
    public String getFirstName(){
       return personRepository.findAll().get(0).getFirstName();
    }

    //******************************** Customer Controller starts **********************************************************

    @GetMapping("customerList") //visszatérési érték alapján egy view resolvert keres (template nevet)
    public String getCustomerList(Model model){
        model.addAttribute("customers",customerRepository.findAll());
        model.addAttribute("customer", new Customer());
        return "customer";
    }


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
            model.addAttribute("idType",customer.getIdType());
            model.addAttribute("idNumber",customer.getIdNumber());
            model.addAttribute("addressCountry",customer.getAddressCountry());
            model.addAttribute("addressCity",customer.getAddressCity());
            model.addAttribute("addressFree",customer.getAddressFree());
            //model.addAttribute("isLoyalty",customer.getLoyalty());
           // model.addAttribute("loyaltyCard",customer.getLoyaltyCardNumber());

            customerMap.put(customer.getId(), customer);
            customerRepository.save(customer);
            model.addAttribute("customers", customerRepository.findAll()); //a model a kommunikációs csatorna a html felé
            model.addAttribute("customer", new Customer());
            return "customer";
        }
    }

    //******************************** Customer Controller ends **********************************************************
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome!");
    }

    //********************************************Travelguide Controller ********************************************
    @GetMapping("travelguideList")
    public String getTravelguideList(Model model){
        model.addAttribute("travelguides",travelGuideRepository.findAll());
        model.addAttribute("travelguide", new TravelGuide());
        return "travelguide";
    }

    private Map<Long, TravelGuide> travelguideMap = new HashMap<>();

    @RequestMapping(value = "/saveTravelguide", method = RequestMethod.POST)
    public String submit(
            @ModelAttribute("travelguide") TravelGuide travelguide,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }else {
            model.addAttribute("firstName", travelguide.getFirstName());
            model.addAttribute("lastName", travelguide.getLastName());
            model.addAttribute("birthDate", travelguide.getBirthDate());
            model.addAttribute("idType",travelguide.getIdType());
            model.addAttribute("idNumber",travelguide.getIdNumber());
            model.addAttribute("addressCountry",travelguide.getAddressCountry());
            model.addAttribute("addressCity",travelguide.getAddressCity());
            model.addAttribute("addressFree",travelguide.getAddressFree());
            model.addAttribute("dailyAllowance", travelguide.getDailyAllowance());
            model.addAttribute("taxId", travelguide.getTaxId());


            travelguideMap.put(travelguide.getId(), travelguide);
            travelGuideRepository.save(travelguide);
            model.addAttribute("travelguides", travelGuideRepository.findAll());
            model.addAttribute("travelguide", new TravelGuide());
            return "travelguide";
        }
    }

}
