package com.village.locals.village_locals.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.village.locals.village_locals.beans.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
    public Event findByEventId(Integer eventId);

    public List<Event> findAllByOrganizerOrganizerId(Integer organizerId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE event SET total_bookings=total_bookings+1 WHERE event_id=?", nativeQuery = true)
    public void incrementTotalBookingsOfEventByOne(int eventId);
}
