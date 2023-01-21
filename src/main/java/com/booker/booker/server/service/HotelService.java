package com.booker.booker.server.service;

import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;

import java.util.List;

public interface HotelService
{
    HotelModel saveHotel( HotelModel hotelModel );

    List<HotelIdModel> getAllHotels();
    //HotelModel updateHotel(HotelModel hotelModel, Long hotelId);
    //HotelModel updateNumber( HotelModel hotelModel, Long hotelId);
    //void deleteHotel(Long hotelId);
}
