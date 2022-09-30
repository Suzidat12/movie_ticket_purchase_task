package com.mtb.booking.route;

import com.mtb.booking.dto.paysatckdto.InitiateRequest;
import com.mtb.booking.enums.PaymentStatus;
import com.mtb.booking.model.Payment;
import com.mtb.booking.service.PaymentService;
import jdk.jfr.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor

public class PaymentRoute {
    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity  initiatePayment(@RequestParam("amount") String amount, @RequestBody InitiateRequest request, @RequestParam("userId") Long userId,@RequestParam("ticketId") Long ticketId){
        return paymentService.initiatePayment(amount, request, userId, ticketId);
    }




}
