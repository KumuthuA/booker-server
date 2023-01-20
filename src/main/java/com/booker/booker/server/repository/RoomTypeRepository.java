package com.booker.booker.server.repository;

import com.booker.booker.server.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity,Integer>
{
}
