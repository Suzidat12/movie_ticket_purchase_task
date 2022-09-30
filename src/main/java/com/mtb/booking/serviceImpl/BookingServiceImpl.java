package com.mtb.booking.serviceImpl;

import com.mtb.booking.dto.ApiResponse;
import com.mtb.booking.dto.Ticket;
import com.mtb.booking.exception.DuplicationRecordException;
import com.mtb.booking.exception.RecordNotFoundException;
import com.mtb.booking.model.Movies;
import com.mtb.booking.model.Tbooking;
import com.mtb.booking.model.Users;
import com.mtb.booking.repo.MovieRepo;
import com.mtb.booking.repo.TbookingRepo;
import com.mtb.booking.repo.UserRepo;
import com.mtb.booking.service.BookingService;
import com.mtb.booking.util.Utils;
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
public class BookingServiceImpl implements BookingService {
    private final TbookingRepo tbookingRepo;
    private final UserRepo userRepo;
    private final MovieRepo movieRepo;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    @Override
    public ResponseEntity addBooking(Ticket load, Long userId, Long movieId) {
        List<Tbooking> tbookingsList = tbookingRepo.getCode(load.getCode());
        Optional<Users> usersOptional = userRepo.findById(userId);
        Optional<Movies> moviesOptional = movieRepo.findById(movieId);
        if (!tbookingsList.isEmpty()) {
            throw new DuplicationRecordException(DUPLICATE);
        } else {
            Users users = usersOptional.get();
            Movies movies = moviesOptional.get();
            Tbooking tbooking = new Tbooking();
            tbooking.setTbookingBookedDate(LocalDate.parse(load.getBookedDate(),formatter));
            tbooking.setTbookingMovieTiming(LocalDate.parse(load.getMovieTime(),formatter));
            tbooking.setTbookingUser(users);
            tbooking.setTbookingMovie(movies);
            tbooking.setTicketCode(load.getCode());
            tbooking.setDatecreated(new Date());

            tbookingRepo.save(tbooking);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS));
        }
    }

    @Override
    public ResponseEntity updateBooking(Ticket load, Long ticketId) {
        Optional<Tbooking> tbookOptional = tbookingRepo.findById(ticketId);
        if(tbookOptional.isPresent()){
            Tbooking tbooking= tbookOptional.get();
            tbooking.setTbookingBookedDate(LocalDate.parse(load.getBookedDate(),formatter));
            tbooking.setTbookingMovieTiming(LocalDate.parse(load.getMovieTime(),formatter));
            tbooking.setTicketCode(load.getCode());
            tbooking.setDatecreated(new Date());
            tbookingRepo.save(tbooking);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,SUCCESS));
        }
        throw new RecordNotFoundException(NOT_FOUND);
    }

    @Override
    public ResponseEntity deleteBooking(Long ticketId) {
        Optional<Tbooking> tbookingOptional= tbookingRepo.findById(ticketId);
        if(tbookingOptional.isPresent()){
            Tbooking tbooking = tbookingOptional.get();
            tbookingRepo.delete(tbooking);
            return ResponseEntity.ok(new ApiResponse<>(OKAY,DELETE));
        }
        throw new RecordNotFoundException(NOT_FOUND);
    }

    @Override
    public ResponseEntity listTicket() {
        List<Tbooking> tbookingList = tbookingRepo.findAll();
        return ResponseEntity.ok(new ApiResponse<>(SUCCESS, OKAY,Utils.maptoTicketList(tbookingList)));
    }
}
