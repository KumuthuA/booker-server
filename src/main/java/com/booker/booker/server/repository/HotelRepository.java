package com.booker.booker.server.repository;

import com.booker.booker.server.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer>
{
    @Query( "select h from HotelEntity h where h.email = ?1" )
    Optional<HotelEntity> findByEmail( String email );

    Optional<HotelEntity> findByHotelId( String contractId );

}
