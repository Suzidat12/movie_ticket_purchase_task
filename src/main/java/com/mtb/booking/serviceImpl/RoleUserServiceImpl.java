package com.mtb.booking.serviceImpl;

import com.mtb.booking.dto.ApiResponse;
import com.mtb.booking.dto.RoleUserDto;
import com.mtb.booking.exception.RecordNotFoundException;
import com.mtb.booking.model.Roles;
import com.mtb.booking.model.Roleuser;
import com.mtb.booking.model.Users;
import com.mtb.booking.repo.RoleRepo;
import com.mtb.booking.repo.RoleUsersRepo;
import com.mtb.booking.repo.UserRepo;
import com.mtb.booking.service.RoleUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.mtb.booking.util.AppCode.NOT_FOUND;
import static com.mtb.booking.util.AppCode.OKAY;
import static com.mtb.booking.util.MessageUtil.SUCCESS;

@Service
@RequiredArgsConstructor
public class RoleUserServiceImpl implements RoleUserService {
    private final RoleUsersRepo roleUsersRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public ResponseEntity addRoleUsers(RoleUserDto load, Long userId, Long roleId) {
        Optional<Users> usersOptional = userRepo.findById(userId);
        Optional<Roles> rolesOptional = roleRepo.findById(roleId);
        if(!usersOptional.isPresent() || !rolesOptional.isPresent()){
            throw new RecordNotFoundException(NOT_FOUND);
        }
        Roles roles = rolesOptional.get();
        Users users = usersOptional.get();
        Roleuser roleuser = new Roleuser();
        roleuser.setPlatform(load.getPlatform());
        roleuser.setRoleid(roles);
        roleuser.setUserid(users);
        roleuser.setDatecreated(new Date());
       roleUsersRepo.save(roleuser);
        return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS));
    }

    @Override
    public ResponseEntity updateRoleUsers(RoleUserDto load, Long roleUserId) {
        Optional<Roleuser> rolesUserOptional = roleUsersRepo.findById(roleUserId);
        if(rolesUserOptional .isPresent()){
            Roleuser roleuser = new Roleuser();
            roleuser.setPlatform(load.getPlatform());
            roleuser.setDatecreated(new Date());
            roleUsersRepo.save(roleuser);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS,roleuser));

        }
        return ResponseEntity.ok("Role not updated");
    }
}
