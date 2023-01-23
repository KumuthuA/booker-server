package com.booker.booker.server.repository;

import com.booker.booker.server.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity,Integer>
{
    @Query( """
            select r from RoomTypeEntity r
            where r.contractEntity.hotelEntity.hotelId = ?1 and r.contractEntity.start <= ?2 and r.contractEntity.end >= ?3""" )
    List<RoomTypeEntity> findByContractEntity_HotelEntity_HotelIdAndContractEntity_StartLessThanEqualAndContractEntity_EndGreaterThanEqual( String hotelId, LocalDateTime start, LocalDateTime end );
    List<RoomTypeEntity> findByContractEntity_ContractId( Integer contractNo );
}
