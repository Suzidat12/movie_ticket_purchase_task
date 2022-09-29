package com.mtb.booking.serviceImpl;

import com.mtb.booking.dto.ApiResponse;
import com.mtb.booking.dto.MovieDto;
import com.mtb.booking.enums.MovieStatus;
import com.mtb.booking.enums.MovieType;
import com.mtb.booking.exception.DuplicationRecordException;
import com.mtb.booking.exception.RecordNotFoundException;
import com.mtb.booking.model.Movies;
import com.mtb.booking.model.Users;
import com.mtb.booking.repo.MovieRepo;
import com.mtb.booking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.mtb.booking.util.AppCode.*;
import static com.mtb.booking.util.MessageUtil.DELETE;
import static com.mtb.booking.util.MessageUtil.SUCCESS;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepo movieRepo;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    @Override
    public ResponseEntity addMovie(MovieDto load) {
    List<Movies> moviesList = movieRepo.checkName(load.getName());
    if(!moviesList.isEmpty()){
        throw new DuplicationRecordException(DUPLICATE);

    }else{
        Movies movies = new Movies();
        movies.setMovieHour(load.getHours());
        movies.setMovieName(load.getName());
        movies.setMovieDate(LocalDate.parse(load.getMovieDate(),formatter));
        movies.setMovieLanguage(load.getLanguage());
        movies.setMovieStatus(MovieStatus.Movie_Available.name());
        movies.setMovieType(MovieType.ENGLISH.name());
        movies.setDatecreated(new Date());
        movieRepo.save(movies);
        return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS,movies));
    }

    }

    @Override
    public ResponseEntity updateMovie(MovieDto load, Long movieId) {
        Optional<Movies> moviesOptional= movieRepo.findById(movieId);
        if(moviesOptional.isPresent()){
            Movies movies = moviesOptional.get();
            movies.setMovieHour(load.getHours());
            movies.setMovieName(load.getName());
            movies.setMovieDate(LocalDate.parse(load.getMovieDate()));
            movies.setMovieLanguage(load.getLanguage());
            movies.setMovieStatus(MovieStatus.Movie_Available.name());
            movies.setMovieType(MovieType.ENGLISH.name());
            movies.setDatecreated(new Date());
            movieRepo.save(movies);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS,movies));

        }


        throw new RecordNotFoundException(NOT_FOUND);
    }

    @Override
    public ResponseEntity deleteMovie(Long movieId) {
        Optional<Movies> moviesOptional= movieRepo.findById(movieId);
        if(moviesOptional.isPresent()){
           Movies movies = moviesOptional.get();
            movieRepo.delete(movies);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,DELETE));
        }
        throw new RecordNotFoundException(NOT_FOUND);
    }

    @Override
    public ResponseEntity listMovies() {
        List<Movies> movies = movieRepo.findAll();
        return ResponseEntity.ok(movies);

    }
}
