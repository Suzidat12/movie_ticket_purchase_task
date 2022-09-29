package com.mtb.booking.repo;

import com.mtb.booking.model.Tbooking;
import com.mtb.booking.model.Tbooking_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbookingRepo extends JpaRepository<Tbooking,Long> {
    @Query("select st from Tbooking st where st.ticketCode=?1")
    List<Tbooking> getCode(String code);
}
