package com.mtb.booking.repo;

import com.mtb.booking.model.Roleuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleUsersRepo extends JpaRepository<Roleuser,Long> {
    @Query("select st from Roleuser st where st.userid.usersId=?1")
    List<Roleuser> findByAccount(Long id);
}
