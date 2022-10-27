package com.mtb.booking.route;

import com.mtb.booking.dto.LoginDto;
import com.mtb.booking.dto.RoleDto;
import com.mtb.booking.dto.RoleUserDto;
import com.mtb.booking.dto.UsersDto;
import com.mtb.booking.service.RoleService;
import com.mtb.booking.service.RoleUserService;
import com.mtb.booking.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class UsersRoute {
    private final UsersService usersService;
    private final RoleService roleService;
    private final RoleUserService roleUserService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UsersDto load){
        return usersService.addUsers(load);
    }

    @PostMapping("/addRoleUsers")
    public ResponseEntity addRoleUsers(@RequestBody RoleUserDto load,@RequestParam("userId")Long userId,@RequestParam("roleId")Long roleId){
        return roleUserService.addRoleUsers(load,userId,roleId);
    }

    @PostMapping("/addRole")
    public ResponseEntity addRole(@RequestBody RoleDto  load){
        return roleService.addRole(load);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto login){
        return usersService.login(login);
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UsersDto load, @RequestParam("userId") Long userId){
        return usersService.updateUsers(load, userId);
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser( @RequestParam("userId") Long userId){
        return usersService.deleteUsers(userId);
    }

    @GetMapping("/listUser")
    public ResponseEntity listUsers(){
        return usersService.listUsers();
    }
}
