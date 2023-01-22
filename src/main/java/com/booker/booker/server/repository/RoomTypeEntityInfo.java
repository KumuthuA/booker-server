package com.booker.booker.server.repository;

/**
 * A Projection for the {@link com.booker.booker.server.entity.RoomTypeEntity} entity
 */
public interface RoomTypeEntityInfo
{
    String getRoomTypeId();

    String getTypeName();

    Integer getRoomCount();

    Integer getMaxAdults();

    Float getPrice();

    ContractEntityInfo1 getContractEntity();

    /**
     * A Projection for the {@link com.booker.booker.server.entity.ContractEntity} entity
     */
    interface ContractEntityInfo1
    {
        Integer getContractId();

        HotelEntityInfo1 getHotelEntity();

        /**
         * A Projection for the {@link com.booker.booker.server.entity.HotelEntity} entity
         */
        interface HotelEntityInfo1
        {
            String getHotelId();
        }
    }
}