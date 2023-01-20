package com.booker.booker.server.repository;

import com.booker.booker.server.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends JpaRepository<HotelEntity,Integer>
{
}
