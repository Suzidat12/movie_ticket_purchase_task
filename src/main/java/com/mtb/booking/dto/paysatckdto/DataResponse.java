package com.mtb.booking.dto.paysatckdto;

import lombok.Data;

@Data
public class DataResponse {
    private String authorization_url;
    private String access_code;
    private String reference;
}
