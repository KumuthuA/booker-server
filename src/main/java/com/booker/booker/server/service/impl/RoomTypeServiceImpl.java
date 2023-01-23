package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.RoomTypeConverter;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.exception.ContractNotFoundException;
import com.booker.booker.server.exception.HotelNotFoundException;
import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.repository.ContractRepository;
import com.booker.booker.server.repository.RoomTypeRepository;
import com.booker.booker.server.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService
{
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private RoomTypeConverter roomTypeConverter;
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<RoomTypeModel> getRoomTypes( Integer contractId )
    {
        if( !contractRepository.existsById( contractId ) )
        {
            throw new ContractNotFoundException( "Contract not found!" );
        }
        List<RoomTypeEntity> roomTypeEntityList = ( List<RoomTypeEntity> ) roomTypeRepository.findByContractEntity_ContractId( contractId );
        List<RoomTypeModel> roomTypeModelList = new ArrayList<>();
        for( RoomTypeEntity re : roomTypeEntityList )
        {
            RoomTypeModel roomTypeModel = roomTypeConverter.convertEntityToModel( re );
            roomTypeModelList.add( roomTypeModel );
        }
        return roomTypeModelList;
    }
}
