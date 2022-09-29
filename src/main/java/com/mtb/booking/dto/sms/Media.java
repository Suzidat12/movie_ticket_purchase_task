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
public class Media implements Serializable {
    String url;
    String caption;
}
