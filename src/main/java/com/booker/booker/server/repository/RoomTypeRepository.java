package com.booker.booker.server.repository;

import com.booker.booker.server.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity,Integer>
{
    List<RoomTypeEntity> findByContractEntity_ContractId( Integer contractNo );
}
