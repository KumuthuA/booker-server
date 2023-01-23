package com.booker.booker.server.service;

import com.booker.booker.server.exception.EmailFoundException;
import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.HotelRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.model.SearchModel;

import java.util.HashMap;
import java.util.List;

public interface HotelService
{
    HotelModel saveHotel( HotelModel hotelModel ) throws EmailFoundException;

    List<HotelIdModel> getAllHotels();

    List<HotelModel> getHotels();

    HashMap<String,HotelRoomTypeModel> search( SearchModel searchModel );

    List<RoomTypeModel> getRooms( String hotelId );
}
