package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationModel
{

    private String reservationId;
    private Integer roomTypeId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Integer roomCount;
}
