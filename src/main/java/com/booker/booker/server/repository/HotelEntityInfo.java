package com.booker.booker.server.repository;

/**
 * A Projection for the {@link com.booker.booker.server.entity.HotelEntity} entity
 */
public interface HotelEntityInfo
{
    String getHotelId();

    String getHotelName();

    String getAddress();

    String getCity();

    String getContactNo();

    String getEmail();
}