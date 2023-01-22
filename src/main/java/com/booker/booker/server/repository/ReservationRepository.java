package com.booker.booker.server.repository;

import com.booker.booker.server.entity.ReservationEntity;
import com.booker.booker.server.helpers.compositeKeys.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity,ReservationId>
{
}
