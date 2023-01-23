package com.booker.booker.server.converter;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.model.RoomTypeModel;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeConverter
{
    public RoomTypeEntity convertModelToEntity( RoomTypeModel roomTypeModel, ContractEntity contractEntity )
    {
        RoomTypeEntity roomTypeEntity = new RoomTypeEntity();
        roomTypeEntity.setContractEntity( contractEntity );
        roomTypeEntity.setTypeName( roomTypeModel.getTypeName() );
        roomTypeEntity.setRoomCount( roomTypeModel.getRoomCount() );
        roomTypeEntity.setMaxAdults( roomTypeModel.getMaxAdults() );
        roomTypeEntity.setPrice( roomTypeModel.getPrice() );
        return roomTypeEntity;
    }

    public RoomTypeModel convertEntityToModel( RoomTypeEntity roomTypeEntity )
    {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setRoomTypeId( roomTypeEntity.getRoomTypeId() );
        roomTypeModel.setTypeName( roomTypeEntity.getTypeName() );
        roomTypeModel.setRoomCount( roomTypeEntity.getRoomCount() );
        roomTypeModel.setMaxAdults( roomTypeEntity.getMaxAdults() );
        roomTypeModel.setPrice( roomTypeEntity.getPrice() );
        roomTypeModel.setContractEntityId( roomTypeEntity.getContractEntity().getContractId() );
        return roomTypeModel;
    }

    public RoomTypeModel convertEntityToModelWithMarkedPrice( RoomTypeEntity roomTypeEntity )
    {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setRoomTypeId( roomTypeEntity.getRoomTypeId() );
        roomTypeModel.setTypeName( roomTypeEntity.getTypeName() );
        roomTypeModel.setRoomCount( roomTypeEntity.getRoomCount() );
        roomTypeModel.setMaxAdults( roomTypeEntity.getMaxAdults() );
        roomTypeModel.setPrice( roomTypeEntity.getPrice()*(1+roomTypeEntity.getContractEntity().getMarkup()) );
        roomTypeModel.setContractEntityId( roomTypeEntity.getContractEntity().getContractId() );
        return roomTypeModel;
    }
}
