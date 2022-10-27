package com.mtb.booking.service;

import com.mtb.booking.dto.RoleDto;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity addRole(RoleDto load);
    ResponseEntity updateRole(RoleDto load, Long roleId);


}
