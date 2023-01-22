package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.HotelConverter;
import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.entity.RoomTypeEntity;
import com.booker.booker.server.helpers.TimeConverter;
import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.HotelRoomTypeModel;
import com.booker.booker.server.model.SearchModel;
import com.booker.booker.server.repository.ContractEntityInfo;
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
    private TimeConverter timeConverter = new TimeConverter();
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<HotelRoomTypeModel> search( SearchModel searchModel )
    {
//        System.out.println( searchModel );
//        Map<Integer,Integer> roomDetails = hotelConverter.convertRoomDetailsToHash( searchModel.getRoomDetails() );
//        LocalDateTime start = timeConverter.utcToLocalDateTime( searchModel.getStart() );
//        LocalDateTime end = start.plusDays( searchModel.getNights() );
//        //List <HotelEntity> validHotels = hotelRepository.findByHotelsWithAllMaxAdults(roomDetails.keySet().stream().toList(),roomDetails.size());
//        List<ContractEntityInfo> validContractEntities = contractRepository.findByStartGreaterThanEqualAndEndLessThanEqual( start, end );
//        List<RoomTypeEntity> validRoomTypeEntities = roomTypeRepository.findByMaxAdultsIn( roomDetails.keySet() );
//        HashMap<Integer,List<String>> hotelMaxAdultHash = new HashMap<>();
//        for( Integer maxAdults : roomDetails.keySet() )
//        {
//            for( RoomTypeEntity roomTypeEntity: validRoomTypeEntities
//                  )
//            {
//                hotelMaxAdultHash.merge(maxAdults,roomTypeEntity
//            }
//        }
//        //System.out.println(validHotels.size());
        return null;
    }

    @Override
    public HotelModel saveHotel( HotelModel hotelModel )
    {
        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findByEmail( hotelModel.getEmail());
        if (hotelEntityOptional.isPresent()){
            throw new IllegalStateException("Email taken!");
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


//    @Override
//    public List<HotelModel> getAllHotels()
//    {
//        List<HotelEntity> hotelEntityList = ( List<HotelEntity> ) hotelRepository.findAll();
//        List<HotelModel> hotelModelList = new ArrayList<>();
//        for( HotelEntity he : hotelEntityList )
//        {
//            HotelModel hotelModel = hotelConverter.convertEntityToModel( he );
//            hotelModelList.add( hotelModel );
//        }
//        return hotelModelList;
//    }

//    @Override
//    public HotelModel updateHotel(HotelModel hotelModel, Long hotelId){
//        Optional<HotelEntity> optEn = hotelRepository.findById( hotelId );
//        HotelModel hm = null;
//        if (optEn.isPresent()){
//            HotelEntity he = optEn.get();
//            he.setHotelName(hotelModel.getHotelName());
//            he.setCity( hotelModel.getCity() );
//            he.setAddress( hotelModel.getAddress() );
//            he.setContactNo( hotelModel.getContactNo() );
//            hm = hotelConverter.convertEntityToModel( he );
//            hotelRepository.save(he);
//        }
//        return hm;
//    }
//
//    @Override
//    public HotelModel updateNumber( HotelModel hotelModel, @PathVariable Long hotelId){
//        Optional<HotelEntity> optEn = hotelRepository.findById( hotelId );
//        HotelModel hm = null;
//        if (optEn.isPresent()){
//            HotelEntity he = optEn.get();
//            he.setContactNo( hotelModel.getContactNo() );
//            hm = hotelConverter.convertEntityToModel( he );
//            hotelRepository.save(he);
//        }
//        return hm;
//    }
//
//    @Override
//    public void deleteHotel(Long hotelId){
//        hotelRepository.deleteById( hotelId );
//    }
}
