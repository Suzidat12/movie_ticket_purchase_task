package com.mtb.booking.service;

import com.mtb.booking.dto.MovieDto;
import org.springframework.http.ResponseEntity;

public interface MovieService {
    ResponseEntity addMovie(MovieDto load);
    ResponseEntity updateMovie(MovieDto load, Long movieId);
    ResponseEntity deleteMovie(Long movieId);
    ResponseEntity listMovies();
}
