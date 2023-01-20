package com.booker.booker.server.converter;

import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.model.HotelModel;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter
{
    public HotelEntity convertModelToEntity( HotelModel hotelModel ){
        HotelEntity he = new HotelEntity();
        he.setHotelName(hotelModel.getHotelName());
        he.setCity( hotelModel.getCity() );
        he.setAddress( hotelModel.getAddress() );
        he.setContactNo( hotelModel.getContactNo() );
        he.setEmail( hotelModel.getEmail() );
        return he;
    }

    public HotelModel convertEntityToModel(HotelEntity hotelEntity){
        HotelModel hotelModel = new HotelModel();
        hotelModel.setHotelId(hotelEntity.getHotelId());
        hotelModel.setHotelName(hotelEntity.getHotelName());
        hotelModel.setCity( hotelEntity.getCity() );
        hotelModel.setAddress( hotelEntity.getAddress() );
        hotelModel.setContactNo( hotelEntity.getContactNo() );
        hotelModel.setEmail( hotelEntity.getEmail() );
        return hotelModel;
    }
}
