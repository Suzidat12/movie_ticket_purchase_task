package com.mtb.booking.dto.paysatckdto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class InitiateResponse  {
    private Boolean status;
    private String message;
    private DataResponse data;
}
