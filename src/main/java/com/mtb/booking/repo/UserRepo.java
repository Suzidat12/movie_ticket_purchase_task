package com.mtb.booking.repo;

import com.mtb.booking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<Users,Long> {
    @Query("select st from Users st where st.usersEmail=?1")
    List<Users> checkUser(String email);

    @Query("select st from Users st where st.usersEmail=?1 and st.password=?2")
    List<Users> checkLogin(String email, String password);
}
