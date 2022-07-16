package com.village.locals.village_locals.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.village.locals.village_locals.beans.Booking;
import com.village.locals.village_locals.services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingAPI {

    @Autowired
    BookingService bookingService;

    @PostMapping("/add")
    public int add(@RequestBody Booking booking) {
        return bookingService.add(booking);
    }

    @GetMapping("/getById")
    public Booking getByBookingId(@RequestParam int bookingId) {
        return bookingService.getById(bookingId);
    }

    @GetMapping("/getAllUserBookings")
    public List<Booking> getUserBookings(@RequestParam int userId) {
        return bookingService.getUserBookings(userId);
    }

    @GetMapping("/getAllEventBookings")
    public List<Booking> getEventBookings(@RequestParam int eventId) {
        return bookingService.getEventBookings(eventId);
    }

}
