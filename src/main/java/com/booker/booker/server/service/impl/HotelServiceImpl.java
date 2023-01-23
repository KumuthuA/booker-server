package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.HotelConverter;
import com.booker.booker.server.converter.HotelRoomTypeConverter;
import com.booker.booker.server.converter.RoomTypeConverter;
import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.exception.EmailFoundException;
import com.booker.booker.server.exception.HotelNotFoundException;
import com.booker.booker.server.helpers.TimeConverter;
import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.HotelRoomTypeModel;
import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.model.SearchModel;
import com.booker.booker.server.repository.ContractRepository;
import com.booker.booker.server.repository.HotelRepository;
import com.booker.booker.server.repository.RoomTypeRepository;
import com.booker.booker.server.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelConverter hotelConverter;
    @Autowired
    private HotelRoomTypeConverter hotelRoomTypeConverter;
    @Autowired
    private RoomTypeConverter roomTypeConverter;
    private TimeConverter timeConverter = new TimeConverter();
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public HashMap<String,HotelRoomTypeModel> search( SearchModel searchModel )
    {
        Map<Integer,Integer> roomDetails = hotelConverter.convertRoomDetailsToHash( searchModel.getRoomDetails() );
        Integer adultSum = roomDetails.keySet().stream().mapToInt( Integer::intValue).sum();
        LocalDateTime start = timeConverter.utcToLocalDateTime( searchModel.getStart() );
        LocalDateTime end = start.plusDays( searchModel.getNights() );
        List<ContractEntity> validContractEntities = contractRepository.findByStartLessThanEqualAndEndGreaterThanEqual( start.plusDays( 1 ), end.minusDays( 1 ) );
        HashMap<String,HotelRoomTypeModel> result = new HashMap<>();
        for( ContractEntity contract : validContractEntities )
        {
            List<RoomTypeEntity> validRoomTypeEntities = roomTypeRepository.findByContractEntity_ContractId( contract.getContractId() );
            for( RoomTypeEntity roomTypeEntity : validRoomTypeEntities
            )
            {
                Boolean availability = Boolean.TRUE;
                for( Integer maxAdults : roomDetails.keySet()
                )
                {
                    if( roomTypeEntity.getMaxAdults() < maxAdults || roomDetails.get( maxAdults ) > roomTypeEntity.getRoomCount() )
                    {
                        availability = Boolean.FALSE;
                        break;
                    }
                }
                if( availability == Boolean.TRUE )
                {
                    result.merge( contract.getHotelEntity().getHotelId(), hotelRoomTypeConverter.convertEntityToModel( contract, roomTypeEntity,searchModel.getNights(), adultSum), ( oldVal, newVal ) -> newVal = hotelRoomTypeConverter.convertEntityToModelByAdding( oldVal, contract.getMarkup(), roomTypeEntity, searchModel.getNights(), adultSum ) );
                }
            }
        }
        System.out.println( result.size() );
        return result;
    }

    @Override
    public HotelModel saveHotel( HotelModel hotelModel ) throws EmailFoundException
    {
        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findByEmail( hotelModel.getEmail() );
        if( hotelEntityOptional.isPresent() )
        {
            throw new EmailFoundException( "Email taken!" );
        }
        HotelEntity he = hotelConverter.convertModelToEntity( hotelModel );
        he = hotelRepository.save( he );
        hotelModel = hotelConverter.convertEntityToModel( he );
        return hotelModel;
    }

    @Override
    public List<HotelIdModel> getAllHotels()
    {
        List<HotelEntity> hotelEntityList = ( List<HotelEntity> ) hotelRepository.findAll();
        List<HotelIdModel> hotelIdModelList = new ArrayList<>();
        for( HotelEntity he : hotelEntityList )
        {
            HotelIdModel hotelModel = hotelConverter.convertEntityToHIDModel( he );
            hotelIdModelList.add( hotelModel );
        }
        return hotelIdModelList;
    }

    @Override
    public List<HotelModel> getHotels()
    {
        List<HotelEntity> hotelEntityList = ( List<HotelEntity> ) hotelRepository.findAll();
        List<HotelModel> hotelModelList = new ArrayList<>();
        for( HotelEntity he : hotelEntityList )
        {
            HotelModel hotelModel = hotelConverter.convertEntityToModel( he );
            hotelModelList.add( hotelModel );
        }
        return hotelModelList;
    }

    @Override
    public List<RoomTypeModel> getRooms( String hotelId )
    {
        if( !hotelRepository.existsByHotelId( hotelId ) )
        {
            throw new HotelNotFoundException( "Hotel not found!" );
        }
        LocalDateTime today = LocalDateTime.now();
        List<RoomTypeEntity> roomTypeEntityList = ( List<RoomTypeEntity> ) roomTypeRepository.findByContractEntity_HotelEntity_HotelIdAndContractEntity_StartLessThanEqualAndContractEntity_EndGreaterThanEqual( hotelId, today.plusDays( 1 ), today.minusDays( 1 ) );
        List<RoomTypeModel> roomTypeModelList = new ArrayList<>();
        for( RoomTypeEntity re : roomTypeEntityList )
        {
            RoomTypeModel roomTypeModel = roomTypeConverter.convertEntityToModelWithMarkedPrice( re );
            roomTypeModelList.add( roomTypeModel );
        }
        return roomTypeModelList;
    }

}
