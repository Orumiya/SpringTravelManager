package com.triptech.repositories;

import com.triptech.entities.TravelGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelGuideRepository extends JpaRepository<TravelGuide, Long> {
}
