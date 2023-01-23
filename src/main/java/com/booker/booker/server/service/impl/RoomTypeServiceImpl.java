package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.RoomTypeConverter;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.exception.ContractNotFoundException;
import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.repository.ContractRepository;
import com.booker.booker.server.repository.RoomTypeRepository;
import com.booker.booker.server.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService
{
    Logger logger = LoggerFactory.getLogger( RoomTypeServiceImpl.class );
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private RoomTypeConverter roomTypeConverter;
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<RoomTypeModel> getRoomTypes( Integer contractId )
    {
        logger.info( "Checking if contract exists with the ID:" + contractId );
        if( !contractRepository.existsById( contractId ) )
        {
            throw new ContractNotFoundException( "Contract not found!" );
        }
        logger.info( "Contract exists with the ID:" + contractId );
        logger.info( "Fetching all the roomTypes of the contract:" + contractId );
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
