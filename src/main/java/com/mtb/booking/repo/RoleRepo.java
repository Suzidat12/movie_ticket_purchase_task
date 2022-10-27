package com.mtb.booking.repo;

import com.mtb.booking.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Roles, Long> {
}
