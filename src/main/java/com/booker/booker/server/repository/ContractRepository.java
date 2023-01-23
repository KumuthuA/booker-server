package com.booker.booker.server.repository;

import com.booker.booker.server.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ContractRepository extends JpaRepository<ContractEntity,Integer>
{
    @Query( "select c from ContractEntity c where c.start <= ?1 and c.end >= ?2" )
    List<ContractEntity> findByStartLessThanEqualAndEndGreaterThanEqual( LocalDateTime start, LocalDateTime end );

    @Query( "select c from ContractEntity c where c.end >= ?1" )
    List<ContractEntity> findByEndGreaterThanEqual( LocalDateTime end );

}
