package com.triptech.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TravelGuide {

    @Id
    @GeneratedValue
    private Long id;
    //private Person person;

    private String taxId;
    private Integer dailyAllowance;
    //private List<OnHoliday> onHolidayList;
    //private List<Language> languageList;


}
