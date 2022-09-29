package com.mtb.booking.dto.paysatckdto;

import lombok.Data;

@Data
public class InitiateRequest {
    private String amount;
    private String email;

}
