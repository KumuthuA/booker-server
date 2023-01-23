package com.booker.booker.server.repository;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer>
{
    @Query( "select (count(h) > 0) from HotelEntity h where h.hotelId = ?1" )
    boolean existsByHotelId( String hotelId );
    @Query( "select h from HotelEntity h where h.email = ?1" )
    Optional<HotelEntity> findByEmail( String email );

    Optional<HotelEntity> findByHotelId( String hotelId );

}
