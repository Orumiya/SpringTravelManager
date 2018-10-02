package com.triptech.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends Person {

    private Boolean isLoyalty;

    public Integer getLoyaltyCardNumber() {
        return loyaltyCardNumber;
    }

    public void setLoyaltyCardNumber(Integer loyaltyCardNumber) {
        this.loyaltyCardNumber = loyaltyCardNumber;
    }

    private Integer loyaltyCardNumber;

    @OneToMany
    private List<TourOrder> tourOrderList;

    public List<TourOrder> getTourOrderList() {
        return tourOrderList;
    }

    public void setTourOrderList(List<TourOrder> tourOrderList) {
        this.tourOrderList = tourOrderList;
    }

    public Boolean getLoyalty() {
        return isLoyalty;
    }

    public void setLoyalty(Boolean loyalty) {
        isLoyalty = loyalty;
    }
}
