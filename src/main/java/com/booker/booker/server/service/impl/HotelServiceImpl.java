package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.HotelConverter;
import com.booker.booker.server.entity.HotelEntity;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.repository.HotelRepository;
import com.booker.booker.server.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelConverter hotelConverter;

    @Override
    public HotelModel saveHotel( HotelModel hotelModel )
    {
        HotelEntity he = hotelConverter.convertModelToEntity( hotelModel );
        he = hotelRepository.save(he);
        hotelModel = hotelConverter.convertEntityToModel( he );
        return hotelModel;
    }

    @Override
    public List<HotelModel> getAllHotels()
    {
        List<HotelEntity> hotelEntityList = (List<HotelEntity>)hotelRepository.findAll();
        List<HotelModel> hotelModelList = new ArrayList<>();
        for(HotelEntity he:hotelEntityList){
            HotelModel hotelModel = hotelConverter.convertEntityToModel( he );
            hotelModelList.add(hotelModel);
        }
        return hotelModelList;
    }

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
