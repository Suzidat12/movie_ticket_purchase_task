package com.mtb.booking.feign;

import com.mtb.booking.dto.paysatckdto.InitiateRequest;
import com.mtb.booking.dto.paysatckdto.InitiateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "Paystack", url = "https://api.paystack.co/")
public interface PaystackFeign {
    @PostMapping(value = "transaction/initialize", produces = "applicaion/json")
    InitiateResponse initiateTransaction(@RequestBody InitiateRequest payload,
                                         @RequestHeader(value = "Authorization", required = true) String authorizationHeader);


}
