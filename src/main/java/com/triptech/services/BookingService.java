package com.triptech.services;

import com.triptech.entities.Customer;
import com.triptech.entities.TourOrder;
import com.triptech.entities.Travel;

public interface BookingService {

    void addBooking(TourOrder order);

    //void modifyBooking(TourOrder tourOrder);

    void cancelBooking(TourOrder tourOrder);

    void payBooking(TourOrder tourOrder);

    public Integer countOrderTotalsum(TourOrder tourOrder);

    void countOrderTotalsumWithCustomerLoyalty(TourOrder tourOrder);

}

