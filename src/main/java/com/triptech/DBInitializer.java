package com.triptech;

import com.triptech.entities.Person;
import com.triptech.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component  //ebbol most lett egy bean
public class DBInitializer implements ApplicationRunner {
    @Autowired
    PersonRepository personRepository;  //ezzel az annotációval beinjektál egy referenciát

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //a spring containernek jeleztük, h alkalmas időpontban hívja meg a metódust
        Person person = new Person();
        person.setFirstName("Lilla");
        person.setLastName("Lila");
        person.setBirthDate(LocalDate.of(1986,03,12));
        personRepository.save(person);

    }
}
