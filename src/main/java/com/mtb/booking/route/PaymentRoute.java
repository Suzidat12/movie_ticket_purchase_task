package com.mtb.booking.route;

import com.mtb.booking.dto.paysatckdto.InitiateRequest;
import com.mtb.booking.enums.PaymentStatus;
import com.mtb.booking.model.Payment;
import com.mtb.booking.service.PaymentService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("https://webhook.site/108510f5-8b76-4bfe-afc3-e1e6f458d6fb")
    public Payment webhook(@RequestBody Payment payment) {
        payment.setAmount(payment.getAmount());
        payment.setCustomer(payment.getCustomer());
        payment.setTicket(payment.getTicket());
        payment.setDatecreated(new Date());
        payment.setStatus(PaymentStatus.PAID.name());
        return payment;
    }


}
