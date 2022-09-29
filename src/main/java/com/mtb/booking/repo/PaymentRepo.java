package com.mtb.booking.repo;

import com.mtb.booking.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
    @Query("select st from Payment st where st.ticket.tbookingId=?1")
    List<Payment> findTicket (Long ticket);
}
