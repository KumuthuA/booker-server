package com.booker.booker.server.service;

import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.HotelRoomTypeModel;

import java.util.List;

public interface HotelService
{
    HotelModel saveHotel( HotelModel hotelModel );

    List<HotelIdModel> getAllHotels();

    List<HotelModel> getHotels();

    List<HotelRoomTypeModel> search();
}
