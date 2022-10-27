package com.mtb.booking.service;

import com.mtb.booking.dto.RoleUserDto;
import org.springframework.http.ResponseEntity;

public interface RoleUserService {
    ResponseEntity addRoleUsers(RoleUserDto load, Long userId, Long roleId);
    ResponseEntity updateRoleUsers(RoleUserDto load, Long roleUserId);
}
