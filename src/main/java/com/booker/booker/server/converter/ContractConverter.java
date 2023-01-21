package com.booker.booker.server.converter;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.helpers.TimeConverter;
import com.booker.booker.server.model.ContractRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ContractConverter
{

    public ContractEntity convertModelToEntity( ContractRoomTypeModel contractRoomTypeModel, HotelEntity hotelEntity )
    {
        TimeConverter timeConverter = new TimeConverter();
        ContractEntity ce = new ContractEntity();
        //ce.setHotelId(contractModel.getHotelId());
        LocalDateTime start = timeConverter.utcToLocalDateTime( contractRoomTypeModel.getStart() );
        LocalDateTime end = timeConverter.utcToLocalDateTime( contractRoomTypeModel.getEnd() );
        ce.setContractNo( contractRoomTypeModel.getContractNo() );
        ce.setHotelEntity( hotelEntity );
        ce.setStart( start );
        ce.setEnd( end );
        ce.setIsValid( end.isAfter( LocalDateTime.now() ) );
        ce.setMarkup( contractRoomTypeModel.getMarkup() );
        return ce;
    }

    public ContractRoomTypeModel convertEntityToModel( ContractEntity contractEntity, List<RoomTypeModel> roomTypeModelList )
    {
        ContractRoomTypeModel cm = new ContractRoomTypeModel();
        cm.setContractId( contractEntity.getContractId() );
        //cm.setHotel(contractEntity.getHotel());
        cm.setContractNo( contractEntity.getContractNo() );
        cm.setStart( contractEntity.getStart() );
        cm.setEnd( contractEntity.getEnd() );
        cm.setIsValid( contractEntity.getIsValid() );
        cm.setMarkup( contractEntity.getMarkup() );
        cm.setRoomTypes( roomTypeModelList );
        return cm;
    }
}
