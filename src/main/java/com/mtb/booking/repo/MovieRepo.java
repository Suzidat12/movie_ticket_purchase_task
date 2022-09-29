package com.mtb.booking.repo;

import com.mtb.booking.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movies,Long> {
    @Query("select st from Movies st where st.movieName=?1")
    List<Movies> checkName(String name);
}
