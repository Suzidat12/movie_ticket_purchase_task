package com.mtb.booking.service;

import com.mtb.booking.dto.paysatckdto.InitiateRequest;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity initiatePayment(String amount, InitiateRequest request, Long userId, Long ticketId);

}
