package com.mtb.booking.dto;

import lombok.Data;

@Data
public class LoginResponse {
    String response;
    UsersDto data;
}
