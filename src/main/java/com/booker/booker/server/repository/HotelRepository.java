package com.booker.booker.server.repository;

import com.booker.booker.server.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer>
{
    HotelEntity findByHotelId( String contractId );

}
