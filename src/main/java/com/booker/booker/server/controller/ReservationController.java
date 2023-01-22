package com.booker.booker.server.controller;

import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.ReservationModel;
import com.booker.booker.server.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1" )
public class ReservationController
{
    @Autowired
    ReservationService reservationService;
    @PostMapping( "/reserve" )
    public ResponseEntity<ReservationModel> saveReservation( @RequestBody ReservationModel reservationModel )
    {
        System.out.println( reservationModel );
        reservationModel = reservationService.saveReservation( reservationModel );
        ResponseEntity<ReservationModel> responseEntity = new ResponseEntity<>( reservationModel, HttpStatus.CREATED );
        return responseEntity;
    }
}
