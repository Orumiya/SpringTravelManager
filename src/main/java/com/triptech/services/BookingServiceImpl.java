package com.triptech.services;

import com.triptech.entities.Customer;
import com.triptech.entities.TourOrder;
import com.triptech.entities.Travel;
import com.triptech.repositories.TourOrderRepository;
import com.triptech.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    TourOrderRepository tourOrderRepository;
    @Autowired
    TravelRepository travelRepository;

    @Override
    public void addBooking(TourOrder order) {

        checkTravelMaxNumberExceedInOrder(order);
        tourOrderRepository.save(order);

    }

    @Override
    public void cancelBooking(TourOrder tourOrder) {

        if(!tourOrder.getCancelled()){
            tourOrder.setCancelled(true);
        }
        tourOrderRepository.save(tourOrder);
    }

    @Override
    public void payBooking(TourOrder tourOrder) {
        if(!tourOrder.getPayed()){
            tourOrder.setPayed(true);
        }
        tourOrderRepository.save(tourOrder);
    }

    @Override
    public Integer countOrderTotalsum(TourOrder tourOrder) {
        Integer adultSum = tourOrder.getAdultCount() * tourOrder.getBookedTravel().getAdultPrice();
        Integer childSum = tourOrder.getChildCount() * tourOrder.getBookedTravel().getChildPrice();
        Integer totalSum = adultSum + childSum;
        return totalSum;
    }

    @Override
    public void countOrderTotalsumWithCustomerLoyalty(TourOrder tourOrder) {
        Integer totalSum = countOrderTotalsum(tourOrder);

        if(tourOrder.getCustomer().getLoyalty()){

        }
        tourOrder.setTotalSum(totalSum);
    }

    private void checkTravelMaxNumberExceedInOrder(TourOrder order){

        Long bookedTravelId = order.getBookedTravel().getId();
        Travel bookedTravel = travelRepository.getOne(bookedTravelId);

        int count = 0;
        for (TourOrder item: bookedTravel.getTourOrderList()
             ) {
            if(!item.getCancelled()) {
                count += item.getAdultCount() + item.getChildCount();
            }
        }

        if(order.getAdultCount() + order.getChildCount() + count > bookedTravel.getMaxNumber()){
            throw new TravelMaxNumberExceedException();
        }
    }


    //Todo: lookup id --> object
    //Todo: assign Travel to order etc (addBooking előtt)

}
