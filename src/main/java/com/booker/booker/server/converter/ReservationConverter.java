package com.booker.booker.server.converter;

import com.booker.booker.server.entity.ReservationEntity;
import com.booker.booker.server.model.ReservationModel;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverter
{
    public ReservationEntity convertModelToEntity( ReservationModel reservationModel )
    {
        ReservationEntity re = new ReservationEntity();
        //re.setRoomTypeEntity( reservationModel.getRoomTypeId() );
        re.setCheckIn( reservationModel.getCheckIn() );
        re.setCheckOut( reservationModel.getCheckOut() );
        re.setRoomCount( reservationModel.getRoomCount() );
        return re;
    }

    public ReservationModel convertEntityToModel( ReservationEntity reservationEntity )
    {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setReservationId( reservationEntity.getReservationId() );
        reservationModel.setRoomTypeId( reservationEntity.getRoomTypeEntity().getRoomTypeId() );
        reservationModel.setCheckIn( reservationEntity.getCheckIn() );
        reservationModel.setCheckOut( reservationEntity.getCheckOut() );
        reservationModel.setRoomCount( reservationEntity.getRoomCount() );
        return reservationModel;
    }
}
