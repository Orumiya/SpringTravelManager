package com.triptech.entities;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class TravelGuide {

    private Person person;
    private String taxId;
    private Integer dailyAllowance;
    private List<OnHoliday> onHolidayList;
    private List<Language> languageList;


}
