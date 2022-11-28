package com.mtb.booking.security.filters;

import com.mtb.booking.exception.RecordNotFoundException;
import com.mtb.booking.model.Users;
import com.mtb.booking.repo.RoleUsersRepo;
import com.mtb.booking.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    private final RoleUsersRepo roleUserRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<Users> user = userRepo.isRecordExists(email);
        if (user == null || user.isEmpty()) {
            throw new RecordNotFoundException("UserName " + email + " not found");
        }
        Users rs = user.get(0);
        return new CustomUserDetails(rs, roleUserRepo.findByAccount(rs.getUsersId()));
    }
//        return new User("foo", "foo", new ArrayList<>());
    }

