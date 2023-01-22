package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.ContractConverter;
import com.booker.booker.server.converter.RoomTypeConverter;
import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.exception.HotelNotFoundException;
import com.booker.booker.server.model.ContractModel;
import com.booker.booker.server.model.ContractRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.repository.ContractRepository;
import com.booker.booker.server.repository.HotelRepository;
import com.booker.booker.server.repository.RoomTypeRepository;
import com.booker.booker.server.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService
{
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

    @Override
    public ContractRoomTypeModel saveContract( ContractRoomTypeModel contractRoomTypeModel )
    {
        HotelEntity hotelEntity = hotelRepository.findById( contractRoomTypeModel.getHotelId() ).orElseThrow( () -> new HotelNotFoundException( "Hotel not found " ) );
        ContractEntity contractEntity = contractConverter.convertModelToEntity( contractRoomTypeModel, hotelEntity );
        List<RoomTypeModel> roomTypes = contractRoomTypeModel.getRoomTypes();
        contractEntity = contractRepository.save( contractEntity );
        List<RoomTypeModel> roomTypeModelList = new ArrayList<RoomTypeModel>();
        for( RoomTypeModel roomTypeModel : roomTypes
        )
        {
            RoomTypeEntity roomTypeEntity = roomTypeConverter.convertModelToEntity( roomTypeModel, contractEntity );
            roomTypeEntity = roomTypeRepository.save( roomTypeEntity );
            roomTypeModelList.add( roomTypeConverter.convertEntityToModel( roomTypeEntity ) );
        }
        contractRoomTypeModel = contractConverter.convertEntityToModel( contractEntity, roomTypeModelList );
        return contractRoomTypeModel;
    }

    @Override
    public List<ContractModel> getContracts()
    {
        List<ContractEntity> contractEntityList = ( List<ContractEntity> ) contractRepository.findAll();
        List<ContractModel> contractModelList = new ArrayList<>();
        for( ContractEntity ce : contractEntityList )
        {
            ContractModel contractModel = contractConverter.convertEntityToModel( ce );
            contractModelList.add( contractModel );
        }
        return contractModelList;
    }
//
//    @Override
//    public List<ContractModel> getAllValidContracts()
//    {
//        List<ContractEntity> contractEntityList = ( List<ContractEntity> ) contractRepository.findAll();
//        List<ContractModel> contractModelList = new ArrayList<>();
//        for( ContractEntity ce : contractEntityList )
//        {
//            ContractModel contractModel = contractConverter.convertEntityToModel( ce );
//            contractModelList.add( contractModel );
//        }
//        return contractModelList;
//    }
}
