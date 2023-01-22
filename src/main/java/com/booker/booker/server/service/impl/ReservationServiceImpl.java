package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.ReservationConverter;
import com.booker.booker.server.entity.ReservationEntity;
import com.booker.booker.server.model.ReservationModel;
import com.booker.booker.server.repository.ReservationRepository;
import com.booker.booker.server.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService
{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationConverter reservationConverter;

    @Override
    public ReservationModel saveReservation( ReservationModel reservationModel )
    {
        ReservationEntity se = reservationConverter.convertModelToEntity( reservationModel );
        se = reservationRepository.save( se );
        reservationModel = reservationConverter.convertEntityToModel( se );
        return reservationModel;
    }
}
