/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtb.booking.dto.sms;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author Olasunkanmi
 */
@Data
public class SmsResponse implements Serializable {
    String message_id;
    String message;
    Long balance;
    String user;
    
    
}
