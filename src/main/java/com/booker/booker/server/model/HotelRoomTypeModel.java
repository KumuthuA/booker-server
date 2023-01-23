package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelRoomTypeModel
{
    private String hotelId;
    private String hotelName;
    private String address;
    private String city;
    private String contactNo;
    private String email;    private List<RoomTypeModel> roomTypeModelList;
}
