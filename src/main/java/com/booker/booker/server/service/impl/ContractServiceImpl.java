package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.ContractConverter;
import com.booker.booker.server.converter.RoomTypeConverter;
import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.exception.ContractAlreadyExistsException;
import com.booker.booker.server.exception.HotelNotFoundException;
import com.booker.booker.server.model.ContractModel;
import com.booker.booker.server.model.ContractRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.repository.ContractRepository;
import com.booker.booker.server.repository.HotelRepository;
import com.booker.booker.server.repository.RoomTypeRepository;
import com.booker.booker.server.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService
{
    Logger logger = LoggerFactory.getLogger( ContractServiceImpl.class );
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ContractConverter contractConverter;
    @Autowired
    private RoomTypeConverter roomTypeConverter;
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    /*
        Save contract details to the database
    */
    @Override
    public ContractRoomTypeModel saveContract( ContractRoomTypeModel contractRoomTypeModel ) throws ContractAlreadyExistsException
    {
        Optional<HotelEntity> hotelEntity = hotelRepository.findByHotelId( contractRoomTypeModel.getHotelId() );
        logger.info( "Checking if the hotel is in the database" );
        if( !hotelEntity.isPresent() )
        {
            throw new HotelNotFoundException( "Hotel id " + contractRoomTypeModel.getHotelId() + " does not exists!" );
        }
        logger.info( "Checking if a contract with the id : " + contractRoomTypeModel.getContractId() + " is in the system" );
        boolean exists = contractRepository.existsById( contractRoomTypeModel.getContractId() );
        if( exists )
        {
            throw new ContractAlreadyExistsException( "Contract with the id '" + contractRoomTypeModel.getContractId() + "' exists already!" );
        }
        ContractEntity contractEntity = contractConverter.convertModelToEntity( contractRoomTypeModel, hotelEntity.get() );
        List<RoomTypeModel> roomTypes = contractRoomTypeModel.getRoomTypes();
        contractEntity = contractRepository.save( contractEntity );
        logger.info( "Contract with the id : " + contractRoomTypeModel.getContractId() + " saved successfully" );
        List<RoomTypeModel> roomTypeModelList = new ArrayList<RoomTypeModel>();
        for( RoomTypeModel roomTypeModel : roomTypes
        )
        {
            RoomTypeEntity roomTypeEntity = roomTypeConverter.convertModelToEntity( roomTypeModel, contractEntity );
            roomTypeEntity = roomTypeRepository.save( roomTypeEntity );
            logger.info( "Room type with the name : " + roomTypeEntity.getTypeName() + " saved successfully" );
            roomTypeModelList.add( roomTypeConverter.convertEntityToModel( roomTypeEntity ) );
        }
        contractRoomTypeModel = contractConverter.convertEntityToModel( contractEntity, roomTypeModelList );
        return contractRoomTypeModel;
    }

    /*
        Retrieving all the non-expired contracts from the database
    */
    @Override
    public List<ContractModel> getContracts()
    {
        List<ContractEntity> contractEntityList = ( List<ContractEntity> ) contractRepository.findByEndGreaterThanEqual( LocalDateTime.now() );
        List<ContractModel> contractModelList = new ArrayList<>();
        for( ContractEntity ce : contractEntityList )
        {
            ContractModel contractModel = contractConverter.convertEntityToModel( ce );
            contractModelList.add( contractModel );
        }
        return contractModelList;
    }

}
