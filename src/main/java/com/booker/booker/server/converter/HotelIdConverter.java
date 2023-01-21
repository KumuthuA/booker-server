package com.booker.booker.server.converter;

import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.model.HotelIdModel;
import org.springframework.stereotype.Component;

@Component
public class HotelIdConverter
{
    public HotelIdModel convertEntityToModel( HotelEntity hotelEntity )
    {
        HotelIdModel hotelIdModel = new HotelIdModel();
        hotelIdModel.setHotelName( hotelEntity.getHotelName() );
        hotelIdModel.setHotelId( hotelEntity.getHotelId() );
        hotelIdModel.setCity( hotelEntity.getCity() );
        return hotelIdModel;
    }
}
