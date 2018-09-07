package com.triptech.repositories;

import com.triptech.entities.TourOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourOrderRepository extends JpaRepository<TourOrder, Long> {
}
