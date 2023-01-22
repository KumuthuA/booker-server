package com.booker.booker.server.repository;

/**
 * A Projection for the {@link com.booker.booker.server.entity.ContractEntity} entity
 */
public interface ContractEntityInfo
{
    Integer getContractId();

    Float getMarkup();

    HotelEntityInfo getHotelEntity();
}