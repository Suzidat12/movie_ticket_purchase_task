package com.mtb.booking.route;

import com.mtb.booking.dto.Ticket;
import com.mtb.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TbookingRoute {
    private final BookingService bookingService;

    @PostMapping("/addTicket")
    public ResponseEntity addBooking(@RequestBody Ticket load, @RequestParam("userId")Long userId, @RequestParam("movieId")Long movieId){
        return bookingService.addBooking(load,userId,movieId);
    }

    @PutMapping("/updateTicket")
    public ResponseEntity updateBooking(@RequestBody Ticket load, @RequestParam("ticketId")Long ticketId){
        return bookingService.updateBooking(load, ticketId);
    }

    @DeleteMapping("/deleteTicket")
    public ResponseEntity deleteBooking( @RequestParam("ticketId")Long ticketId){
        return bookingService.deleteBooking(ticketId);
    }

    @GetMapping("/listTicket")
    public ResponseEntity<?> listTicket(){
        return bookingService.listTicket();
    }
}
