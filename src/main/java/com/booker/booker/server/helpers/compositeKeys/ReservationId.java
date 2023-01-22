package com.booker.booker.server.helpers.compositeKeys;

import com.booker.booker.server.entity.RoomTypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReservationId implements Serializable
{
    private String reservationId;
    private RoomTypeEntity roomTypeEntity;

    public ReservationId( String reservationId, RoomTypeEntity roomTypeEntity )
    {
        this.reservationId = reservationId;
        this.roomTypeEntity = roomTypeEntity;
    }
}
