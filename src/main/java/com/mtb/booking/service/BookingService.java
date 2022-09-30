package com.mtb.booking.service;

import com.mtb.booking.dto.Ticket;
import org.springframework.http.ResponseEntity;

public interface BookingService {
    ResponseEntity addBooking(Ticket load, Long userId, Long movieId);
    ResponseEntity updateBooking(Ticket load , Long ticketId);
    ResponseEntity deleteBooking(Long ticketId);
    ResponseEntity<?> listTicket();
}
