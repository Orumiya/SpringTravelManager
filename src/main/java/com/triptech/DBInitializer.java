package com.triptech;

import com.triptech.entities.*;
import com.triptech.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Arrays;

@Component  //ebbol most lett egy bean
public class DBInitializer implements ApplicationRunner {
    @Autowired
    PersonRepository personRepository;  //ezzel az annotációval beinjektál egy referenciát
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    TourOrderRepository tourOrderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TravelGuideRepository travelGuideRepository;
    @Autowired
    EntityManager entityManager;
    //LanguageRepository languageRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //a spring containernek jeleztük, h alkalmas időpontban hívja meg a metódust
        Customer customer = new Customer();
        customer.setFirstName("Lilla");
        customer.setLastName("Lila");
        customer.setBirthDate(LocalDate.of(1986,03,12));

        customerRepository.save(customer);

        Office office = new Office();
        office.setOfficeName("Happy Sunshine Travel");
        office.setAddressCity("Budapest");
        office.setTaxId("123456789");
        office.setAddressCountry("Hungary");
        office.setAddressFree("Neumann 1");
        office.setAddressZip("1111");
        officeRepository.save(office);

        Customer customer2 = new Customer();

        customer2.setFirstName("Kelemen");
        customer2.setLoyalty(true);
        TourOrder newOrder = new TourOrder();
        newOrder.setTotalSum(1200000);
        tourOrderRepository.save(newOrder);
        TourOrder order3 = new TourOrder();
        order3.setTotalSum(32000);
        tourOrderRepository.save(order3);

        customer.setTourOrderList(Arrays.asList(newOrder, order3));
        customerRepository.save(customer);

        Language lang1 = entityManager.find(Language.class, "german");
                if(lang1 == null){
                    lang1 = new Language();
                    lang1.setLang("german");
                }
        //Language lang2 = new Language();
        //lang2.setLang("perzsa");
        TravelGuide guide = new TravelGuide();
        guide.setTaxId("121212123");
        guide.setLanguageList(Arrays.asList(lang1));

        travelGuideRepository.save(guide);




    }
}
