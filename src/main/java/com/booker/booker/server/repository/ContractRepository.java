package com.booker.booker.server.repository;

import com.booker.booker.server.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity,Integer>
{
}
