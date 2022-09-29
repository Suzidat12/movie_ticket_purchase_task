package com.mtb.booking.service;

import com.mtb.booking.dto.LoginDto;
import com.mtb.booking.dto.UsersDto;
import org.springframework.http.ResponseEntity;

public interface UsersService {
    ResponseEntity addUsers(UsersDto load);
    ResponseEntity updateUsers(UsersDto load, Long userId);
    ResponseEntity deleteUsers(Long userId);
    ResponseEntity listUsers();
    ResponseEntity login(LoginDto login);
}
