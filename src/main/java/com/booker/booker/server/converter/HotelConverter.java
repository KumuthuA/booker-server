package com.booker.booker.server.converter;

import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.RoomDetailsModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class HotelConverter
{
    public HotelEntity convertModelToEntity( HotelModel hotelModel )
    {
        HotelEntity he = new HotelEntity();
        he.setHotelName( hotelModel.getHotelName() );
        he.setCity( hotelModel.getCity() );
        he.setAddress( hotelModel.getAddress() );
        he.setContactNo( hotelModel.getContactNo() );
        he.setEmail( hotelModel.getEmail() );
        return he;
    }

    public HotelModel convertEntityToModel( HotelEntity hotelEntity )
    {
        HotelModel hotelModel = new HotelModel();
        hotelModel.setHotelId( hotelEntity.getHotelId() );
        hotelModel.setHotelName( hotelEntity.getHotelName() );
        hotelModel.setCity( hotelEntity.getCity() );
        hotelModel.setAddress( hotelEntity.getAddress() );
        hotelModel.setContactNo( hotelEntity.getContactNo() );
        hotelModel.setEmail( hotelEntity.getEmail() );
        return hotelModel;
    }

    public HotelIdModel convertEntityToHIDModel( HotelEntity hotelEntity )
    {
        HotelIdModel hotelIdModel = new HotelIdModel();
        hotelIdModel.setHotelName( hotelEntity.getHotelName() );
        hotelIdModel.setHotelId( hotelEntity.getHotelId() );
        hotelIdModel.setCity( hotelEntity.getCity() );
        return hotelIdModel;
    }

    public HashMap<Integer,Integer> convertRoomDetailsToHash( List<RoomDetailsModel> roomDetails )
    {
        HashMap<Integer,Integer> roomDetailsHashMap = new HashMap<>();
        for( RoomDetailsModel roomDetailsModel : roomDetails )
        {
            roomDetailsHashMap.merge( roomDetailsModel.getAdultsPerRoom(), roomDetailsModel.getRoomCount(), ( oldVal, newVal ) -> oldVal + newVal );
        }
        return roomDetailsHashMap;
    }
}
