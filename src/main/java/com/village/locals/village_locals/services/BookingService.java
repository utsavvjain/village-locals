package com.village.locals.village_locals.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.village.locals.village_locals.beans.Booking;
import com.village.locals.village_locals.beans.Event;
import com.village.locals.village_locals.repositories.BookingRepository;
import com.village.locals.village_locals.repositories.EventRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    EventRepository eventRepository;

    public int add(Booking booking) {
        // TODO :: VALIDATIONS
        Event event = eventRepository.findByEventId(booking.getEvent().getEventId());
        if (event.getCapacity() == event.getTotalBookings()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Capacity for event full");
        }
        if(bookingRepository.existsByEventEventIdAndUserUserId(booking.getEvent().getEventId(),booking.getUser().getUserId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"User already registered");
        }
        bookingRepository.save(booking);
        eventRepository.incrementTotalBookingsOfEventByOne(booking.getEvent().getEventId());
        return booking.getBookingId();
    }

    public Booking getById(int bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (!booking.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return booking.get();
    }

    public List<Booking> getUserBookings(int userId) {
        return bookingRepository.findAllByUserUserId(userId);
    }

    public List<Booking> getEventBookings(int eventId) {
        return bookingRepository.findAllByEventEventId(eventId);
    }

}
