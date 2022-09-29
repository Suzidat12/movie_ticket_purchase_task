package com.mtb.booking.route;

import com.mtb.booking.dto.MovieDto;
import com.mtb.booking.dto.UsersDto;
import com.mtb.booking.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class MoviesRoute {
    private final MovieService movieService;

    @PostMapping("/addMovies")
    public ResponseEntity addMovie(@RequestBody MovieDto load){
        return movieService.addMovie(load);
    }

    @PutMapping("/updateMovie")
    public ResponseEntity updateMovie(@RequestBody MovieDto load, @RequestParam("movieId") Long movieId){
        return movieService.updateMovie(load, movieId);
    }

    @DeleteMapping("/deleteMovie")
    public ResponseEntity deleteMovie( @RequestParam("movieId") Long movieId){
        return movieService.deleteMovie(movieId);
    }

    @GetMapping("/listMovies")
    public ResponseEntity listMovies(){
        return movieService.listMovies();
    }
}
