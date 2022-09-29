package com.mtb.booking.util;

import com.mtb.booking.dto.UsersDto;
import com.mtb.booking.model.Users;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
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
}
