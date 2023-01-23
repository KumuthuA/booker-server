package com.booker.booker.server.converter;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.model.HotelRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRoomTypeConverter
{
    public HotelRoomTypeModel convertEntityToModel( ContractEntity contractEntity, RoomTypeEntity roomTypeEntity, Integer nights, Integer adultsSum )
    {
        HotelRoomTypeModel hotelRoomTypeModel = new HotelRoomTypeModel();
        List<RoomTypeModel> roomTypeModelList = new ArrayList<>();
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        hotelRoomTypeModel.setHotelId( contractEntity.getHotelEntity().getHotelId() );
        hotelRoomTypeModel.setHotelName( contractEntity.getHotelEntity().getHotelName() );
        hotelRoomTypeModel.setEmail( contractEntity.getHotelEntity().getEmail() );
        hotelRoomTypeModel.setAddress( contractEntity.getHotelEntity().getAddress() );
        hotelRoomTypeModel.setCity( contractEntity.getHotelEntity().getCity() );
        hotelRoomTypeModel.setContactNo( contractEntity.getHotelEntity().getContactNo() );
        roomTypeModel.setRoomTypeId( roomTypeEntity.getRoomTypeId() );
        roomTypeModel.setTypeName( roomTypeEntity.getTypeName() );
        roomTypeModel.setRoomCount( roomTypeEntity.getRoomCount() );
        roomTypeModel.setMaxAdults( roomTypeEntity.getMaxAdults() );
        roomTypeModel.setPrice( roomTypeEntity.getPrice() * ( 1 + contractEntity.getMarkup() ) * nights * adultsSum );
        roomTypeModel.setContractEntityId( roomTypeEntity.getContractEntity().getContractId() );
        roomTypeModelList.add( roomTypeModel );
        hotelRoomTypeModel.setRoomTypeModelList( roomTypeModelList );
        return hotelRoomTypeModel;
    }

    public HotelRoomTypeModel convertEntityToModelByAdding( HotelRoomTypeModel hotelRoomTypeModel, Float markup, RoomTypeEntity roomTypeEntity , Integer nights, Integer adultsSum)
    {
        RoomTypeModel roomTypeModel = new RoomTypeModel();
        roomTypeModel.setRoomTypeId( roomTypeEntity.getRoomTypeId() );
        roomTypeModel.setTypeName( roomTypeEntity.getTypeName() );
        roomTypeModel.setRoomCount( roomTypeEntity.getRoomCount() );
        roomTypeModel.setMaxAdults( roomTypeEntity.getMaxAdults() );
        roomTypeModel.setPrice( roomTypeEntity.getPrice() * ( 1 + markup ) * nights * adultsSum );
        roomTypeModel.setContractEntityId( roomTypeEntity.getContractEntity().getContractId() );
        List<RoomTypeModel> roomTypeModelList = hotelRoomTypeModel.getRoomTypeModelList();
        roomTypeModelList.add( roomTypeModel );
        hotelRoomTypeModel.setRoomTypeModelList( roomTypeModelList );
        return hotelRoomTypeModel;
    }
}
