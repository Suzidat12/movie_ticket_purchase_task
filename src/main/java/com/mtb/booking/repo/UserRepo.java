package com.mtb.booking.repo;

import com.mtb.booking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,Long> {
    @Query("select st from Users st where st.usersEmail=?1")
    List<Users> checkUser(String email);

    @Query("select st from Users st where st.usersEmail=?1 and st.password=?2")
    List<Users> checkLogin(String email, String password);

    @Query(value="select * from users  where users_email=:email "
            + "or users_mobile_no=:email",
            nativeQuery=true)
    List<Users> isRecordExists(@Param("email")String email);
   // Optional<Users> findByUsername(String usersName);

//    Boolean existsByUsername(String usersName);

//    Boolean existsByEmail(String usersEmail);
}
