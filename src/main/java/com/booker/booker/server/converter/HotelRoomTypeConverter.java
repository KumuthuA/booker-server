package com.booker.booker.server.converter;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.HotelRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRoomTypeConverter
{
    public HotelRoomTypeModel convertEntityToModel( ContractEntity contractEntity, RoomTypeEntity roomTypeEntity )
    {
        HotelRoomTypeModel hotelRoomTypeModel = new HotelRoomTypeModel();
        HotelModel hotelModel = new HotelModel();
        List<RoomTypeModel> roomTypeModelList = new ArrayList<>();
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        hotelModel.setHotelId( contractEntity.getHotelEntity().getHotelId() );
        hotelModel.setHotelName( contractEntity.getHotelEntity().getHotelName() );
        hotelModel.setEmail( contractEntity.getHotelEntity().getEmail() );
        hotelModel.setAddress( contractEntity.getHotelEntity().getAddress() );
        hotelModel.setCity( contractEntity.getHotelEntity().getCity() );
        hotelModel.setContactNo( contractEntity.getHotelEntity().getContactNo() );
        roomTypeModel.setRoomTypeId( roomTypeEntity.getRoomTypeId() );
        roomTypeModel.setTypeName( roomTypeEntity.getTypeName() );
        roomTypeModel.setRoomCount( roomTypeEntity.getRoomCount() );
        roomTypeModel.setMaxAdults( roomTypeEntity.getMaxAdults() );
        roomTypeModel.setPrice( roomTypeEntity.getPrice() );
        roomTypeModel.setContractEntityId( roomTypeEntity.getContractEntity().getContractId() );
        roomTypeModelList.add( roomTypeModel );
        hotelRoomTypeModel.setHotelModel( hotelModel );
        hotelRoomTypeModel.setRoomTypeModelList( roomTypeModelList );
        return hotelRoomTypeModel;
    }

    public HotelRoomTypeModel convertEntityToModelByAdding( HotelRoomTypeModel hotelRoomTypeModel, RoomTypeEntity roomTypeEntity )
    {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setRoomTypeId( roomTypeEntity.getRoomTypeId() );
        roomTypeModel.setTypeName( roomTypeEntity.getTypeName() );
        roomTypeModel.setRoomCount( roomTypeEntity.getRoomCount() );
        roomTypeModel.setMaxAdults( roomTypeEntity.getMaxAdults() );
        roomTypeModel.setPrice( roomTypeEntity.getPrice() );
        roomTypeModel.setContractEntityId( roomTypeEntity.getContractEntity().getContractId() );
        List<RoomTypeModel> roomTypeModelList = hotelRoomTypeModel.getRoomTypeModelList();
        roomTypeModelList.add( roomTypeModel );
        hotelRoomTypeModel.setRoomTypeModelList( roomTypeModelList );
        return hotelRoomTypeModel;
    }
}
