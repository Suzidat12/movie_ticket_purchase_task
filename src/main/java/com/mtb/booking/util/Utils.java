package com.mtb.booking.util;

import com.mtb.booking.dto.MovieDto;
import com.mtb.booking.dto.Ticket;
import com.mtb.booking.dto.UsersDto;
import com.mtb.booking.model.Movies;
import com.mtb.booking.model.Tbooking;
import com.mtb.booking.model.Users;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static UsersDto maptoUsersdto(Users mapfrom) {
        if (mapfrom == null) {
            return null;
        }
        UsersDto mapto = new UsersDto();
        mapto.setUsername(mapfrom.getUsersName());
        mapto.setPassword(mapfrom.getPassword());
        mapto.setUseremail(mapfrom.getUsersEmail());
        mapto.setUsermobile(mapfrom.getUsersMobileNo());
        mapto.setUseraddress(mapfrom.getUsersAddress());

        return mapto;
    }

    public static List<UsersDto> maptoUsersList(List<Users> mapfrom) {
        if (mapfrom == null) {
            return null;
        }
        List<UsersDto> list = new ArrayList<>();
        mapfrom.stream().forEach((rs) -> {
            list.add(maptoUsersdto(rs));
        });
        return list;
    }


    public static String toString(LocalDate l){
        return String.valueOf(l);
    }
    public static List<Ticket> maptoTicketList(List<Tbooking> mapfrom) {

        if (mapfrom == null) {
            return null;
        }
        List<Ticket> list = new ArrayList<>();
        for (Tbooking rs : mapfrom) {
            Ticket data = new Ticket();
            data.setCode(rs.getTicketCode());
            data.setMovieTime(toString(rs.getTbookingMovieTiming()));
            data.setBookedDate(toString(rs.getTbookingBookedDate()));
            list.add(data);
        }
        return list;
    }

    public static List<MovieDto> maptoMoviesList(List<Movies> mapfrom) {

        if (mapfrom == null) {
            return null;
        }
        List<MovieDto> list = new ArrayList<>();
        for (Movies rs : mapfrom) {
            MovieDto data = new MovieDto();
            data.setHours(rs.getMovieHour());
            data.setMovieDate(toString(rs.getMovieDate()));
            data.setName(rs.getMovieName());
            data.setLanguage(rs.getMovieLanguage());
            list.add(data);
        }
        return list;
    }


}
