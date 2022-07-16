package com.village.locals.village_locals.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.village.locals.village_locals.beans.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findAllByUserUserId(int userId);

    List<Booking> findAllByEventEventId(int eventId);

    boolean existsByEventEventIdAndUserUserId(int eventId, int userId); 

}
