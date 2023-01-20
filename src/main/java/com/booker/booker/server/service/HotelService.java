package com.booker.booker.server.service;
import java.util.List;

import com.booker.booker.server.model.HotelModel;
public interface HotelService
{
    HotelModel saveHotel(HotelModel hotelModel);
    List<HotelModel> getAllHotels();
    //HotelModel updateHotel(HotelModel hotelModel, Long hotelId);
    //HotelModel updateNumber( HotelModel hotelModel, Long hotelId);
    //void deleteHotel(Long hotelId);
}
