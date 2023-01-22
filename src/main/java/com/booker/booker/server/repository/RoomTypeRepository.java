package com.booker.booker.server.repository;

import com.booker.booker.server.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity,Integer>
{
    @Query( "select r from RoomTypeEntity r where r.maxAdults in ?1 and r.contractEntity.contractId = ?2" )
    List<RoomTypeEntityInfo> findByMaxAdultsInAndContractEntity_ContractId( Collection<Integer> maxAdults, Integer contractId );
    @Query( "select r from RoomTypeEntity r where r.maxAdults in ?1" )
    List<RoomTypeEntity> findByMaxAdultsIn( Collection<Integer> maxAdults );
    List<RoomTypeEntity> findByContractEntity_ContractId( Integer contractNo );
}
