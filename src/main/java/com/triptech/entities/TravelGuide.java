package com.triptech.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class TravelGuide extends Person{

    private String taxId;
    private Integer dailyAllowance;
    @OneToMany
    private List<OnHoliday> onHolidayList;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Language> languageList;

    @OneToMany
    private List<Travel> travelListOfTourGuide;

    public List<Travel> getTravelListOfTourGuide() {
        return travelListOfTourGuide;
    }

    public void setTravelListOfTourGuide(List<Travel> travelListOfTourGuide) {
        this.travelListOfTourGuide = travelListOfTourGuide;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Integer getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(Integer dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    public List<OnHoliday> getOnHolidayList() {
        return onHolidayList;
    }

    public void setOnHolidayList(List<OnHoliday> onHolidayList) {
        this.onHolidayList = onHolidayList;
    }
}
