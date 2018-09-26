package com.triptech.services;

import com.triptech.entities.TourOrder;
import com.triptech.entities.Travel;
import com.triptech.mocks.OrderRepositoryMock;
import com.triptech.mocks.TravelRepositoryMock;
import com.triptech.repositories.TourOrderRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BookingServiceImplTest {

    @Test(expected = TravelMaxNumberExceedException.class)
    public void addBooking_maxNumberReached_throwsTravelMaxNumberExceedException() {
        TravelRepositoryMock mock = new TravelRepositoryMock();
        TourOrder order = new TourOrder();
        order.setAdultCount(2);
        order.setChildCount(0);
        order.setCancelled(false);

        Travel travel = new Travel();
        travel.setMaxNumber(1);
        order.setBookedTravel(travel);
        travel.setTourOrderList(Arrays.asList(order));


        BookingServiceImpl impl = new BookingServiceImpl();
        impl.travelRepository = mock;
        impl.addBooking(order);
    }

    @Test
    public void cancelBooking_cancelOrder(){

        OrderRepositoryMock mock = new OrderRepositoryMock();
        TourOrder order = new TourOrder();
        order.setId(111L);
        order.setCancelled(false);

        BookingServiceImpl impl = new BookingServiceImpl();
        impl.tourOrderRepository = mock;
        impl.cancelBooking(order);
        Assert.assertTrue(order.getCancelled());
    }

    @Test
    public void payBooking_payOrder(){

        OrderRepositoryMock mock = new OrderRepositoryMock();
        TourOrder order = new TourOrder();
        order.setId(111L);
        order.setPayed(false);

        BookingServiceImpl impl = new BookingServiceImpl();
        impl.tourOrderRepository = mock;
        impl.payBooking(order);
        Assert.assertTrue(order.getPayed());
    }
}