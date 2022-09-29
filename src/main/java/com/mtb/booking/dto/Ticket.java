package com.mtb.booking.dto;

import com.mtb.booking.model.Movies;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Ticket {
    private String code;
    private String bookedDate;
    private String movieTime;

}
