package com.triptech.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TourOrder {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate tourOrderDate;
    private Integer adultCount;
    private Integer childCount;
    private Integer totalSum;
    private Integer totalSumWithLoyalty;
    private Boolean isLoyalty;
    private Boolean isPayed;

    @ManyToOne
    private Travel bookedTravel;

    @ManyToOne()
    private Customer customer;

    public Integer getTotalSumWithLoyalty() {
        return totalSumWithLoyalty;
    }

    public void setTotalSumWithLoyalty(Integer totalSumWithLoyalty) {
        this.totalSumWithLoyalty = totalSumWithLoyalty;
    }


    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }

    private Boolean isCancelled;

    public Travel getBookedTravel() {
        return bookedTravel;
    }

    public void setBookedTravel(Travel bookedTravel) {
        this.bookedTravel = bookedTravel;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTourOrderDate() {
        return tourOrderDate;
    }

    public void setTourOrderDate(LocalDate tourOrderDate) {
        this.tourOrderDate = tourOrderDate;
    }

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public Boolean getLoyalty() {
        return isLoyalty;
    }

    public void setLoyalty(Boolean loyalty) {
        isLoyalty = loyalty;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public void setPayed(Boolean payed) {
        isPayed = payed;
    }



}
