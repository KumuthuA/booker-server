package com.booker.booker.server.controller;

import com.booker.booker.server.exception.EmailFoundException;
import com.booker.booker.server.model.HotelIdModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.model.HotelRoomTypeModel;
import com.booker.booker.server.model.SearchModel;
import com.booker.booker.server.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping( "/api/v1" )
public class HotelController
{
    Logger logger = LoggerFactory.getLogger( HotelController.class );
    @Autowired
    private HotelService hotelService;

    /*
        Post method to add a hotel to database
    */
    @PostMapping( "/hotels" )
    public ResponseEntity<HotelModel> saveHotel( @RequestBody HotelModel hotelModel ) throws EmailFoundException
    {
        hotelModel = hotelService.saveHotel( hotelModel );
        logger.info( "Saving the hotel " + hotelModel.getHotelName() );
        ResponseEntity<HotelModel> responseEntity = new ResponseEntity<>( hotelModel, HttpStatus.CREATED );
        return responseEntity;
    }

    /*
        GET method to retrieve all hotels with their id, name and city
    */
    @GetMapping( "/hotelList" )
    public ResponseEntity<List<HotelIdModel>> getAllHotels()
    {
        List<HotelIdModel> hotelsList = hotelService.getAllHotels();
        logger.info( "Retrieving all hotels" );
        ResponseEntity<List<HotelIdModel>> responseEntity = new ResponseEntity<>( hotelsList, HttpStatus.OK );
        return responseEntity;
    }

    /*
        GET method to get all hotels with their details

        @return
    */
    @GetMapping( "/hotels" )
    public ResponseEntity<List<HotelModel>> getHotels()
    {
        List<HotelModel> hotelsList = hotelService.getHotels();
        ResponseEntity<List<HotelModel>> responseEntity = new ResponseEntity<>( hotelsList, HttpStatus.OK );
        return responseEntity;
    }

    /*    POST method to search hotel availability

        @param searchModel including check-in date, no, of nights, and an array of maxAdults, adultsPerRoom*/
    @PostMapping( "/search" )
    public ResponseEntity<List<HotelRoomTypeModel>> search( @RequestBody SearchModel searchModel )
    {
        HashMap<String,HotelRoomTypeModel> searchResult = hotelService.search( searchModel );
        List<HotelRoomTypeModel> hotelsList = searchResult.values().stream().toList();
        ResponseEntity<List<HotelRoomTypeModel>> responseEntity = new ResponseEntity<>( hotelsList, HttpStatus.OK );
        return responseEntity;
    }
}
