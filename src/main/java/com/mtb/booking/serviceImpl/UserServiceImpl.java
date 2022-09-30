package com.mtb.booking.serviceImpl;

import com.mtb.booking.dto.ApiResponse;
import com.mtb.booking.dto.LoginDto;
import com.mtb.booking.dto.LoginResponse;
import com.mtb.booking.dto.UsersDto;
import com.mtb.booking.exception.DuplicationRecordException;
import com.mtb.booking.exception.RecordNotFoundException;
import com.mtb.booking.model.Users;
import com.mtb.booking.repo.UserRepo;
import com.mtb.booking.service.UsersService;
import com.mtb.booking.util.Utils;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.mtb.booking.util.AppCode.*;
import static com.mtb.booking.util.MessageUtil.DELETE;
import static com.mtb.booking.util.MessageUtil.SUCCESS;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {


    private final UserRepo userRepo;

    @Override
    public ResponseEntity addUsers(UsersDto load) {
        List<Users> usersList = userRepo.checkUser(load.getUseremail());
        if(!usersList.isEmpty()){
            throw new DuplicationRecordException(DUPLICATE);
        }else{
            Users users = new Users();
            users.setUsersName(load.getUsername());
            users.setUsersEmail(load.getUseremail());
            users.setUsersAddress(load.getUseraddress());
            users.setUsersMobileNo(load.getUsermobile());
            users.setPassword(load.getPassword());
            users.setDatecreated(new Date());
            userRepo.save(users);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS,users));
        }

    }

    @Override
    public ResponseEntity updateUsers(UsersDto load, Long userId) {
    Optional<Users> usersOptional= userRepo.findById(userId);
    if(usersOptional.isPresent()){
       Users users = usersOptional.get();
        users.setUsersName(load.getUsername());
        users.setUsersEmail(load.getUseremail());
        users.setUsersAddress(load.getUseraddress());
        users.setUsersMobileNo(load.getUsermobile());
        users.setPassword(load.getPassword());
        users.setDatecreated(new Date());
        userRepo.save(users);
        return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS,users));
    }
        throw new RecordNotFoundException(NOT_FOUND);
    }

    @Override
    public ResponseEntity deleteUsers(Long userId) {
        Optional<Users> usersOptional= userRepo.findById(userId);
        if(usersOptional.isPresent()){
            Users users = usersOptional.get();
            userRepo.delete(users);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,DELETE));
        }
        throw new RecordNotFoundException(NOT_FOUND);
    }

    @Override
    public ResponseEntity listUsers() {
        List<Users> users = userRepo.findAll();
        return ResponseEntity.ok(new ApiResponse<>(SUCCESS, OKAY, Utils.maptoUsersList(users)));
    }

    @Override
    public ResponseEntity login(LoginDto login) {
        List<Users> usersList = userRepo.checkLogin(login.getUserEmail(), login.getPassword());
        List<UsersDto> list = Utils.maptoUsersList(usersList);
        UsersDto acct = null;
        LoginResponse resp = new LoginResponse();
        if (list.isEmpty() ) {

            resp.setResponse("Either username/password not correct...");
            return ResponseEntity.ok(resp);
        } else {
            acct = list.get(0);
            resp.setResponse("Login successfully");
            return ResponseEntity.ok(resp);
        }

    }
}
