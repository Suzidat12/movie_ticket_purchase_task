package com.mtb.booking.serviceImpl;

import com.mtb.booking.dto.RoleDto;
import com.mtb.booking.enums.RoleType;
import com.mtb.booking.model.Roles;
import com.mtb.booking.repo.RoleRepo;
import com.mtb.booking.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    @Override
    public ResponseEntity addRole(RoleDto load) {
        Roles role = new Roles();
        role.setName(load.getName());
        role.setPlatform(load.getPlatform());
        role.setDatecreated(new Date());
        roleRepo.save(role);
        return ResponseEntity.ok("Role created successfully");
    }

    @Override
    public ResponseEntity updateRole(RoleDto load, Long roleId) {
        Optional<Roles> roles = roleRepo.findById(roleId);
        if(roles.isPresent()){
            Roles role = roles.get();
            role.setName(load.getName());
            role.setPlatform(load.getPlatform());
            role.setDatecreated(new Date());
            roleRepo.save(role);
            return ResponseEntity.ok("Role update successfully");

        }
        return ResponseEntity.ok("Role not updated");
    }
}
