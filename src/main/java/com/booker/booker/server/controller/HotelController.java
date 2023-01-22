package com.booker.booker.server.controller;

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

import java.util.List;

@RestController
@RequestMapping( "/api/v1" )
public class HotelController
{
    Logger logger = LoggerFactory.getLogger( HotelController.class );
    @Autowired
    private HotelService hotelService;

    @PostMapping( "/hotels" )
    public ResponseEntity<HotelModel> saveHotel( @RequestBody HotelModel hotelModel )
    {
        System.out.println( hotelModel );
        hotelModel = hotelService.saveHotel( hotelModel );
        ResponseEntity<HotelModel> responseEntity = new ResponseEntity<>( hotelModel, HttpStatus.CREATED );
        return responseEntity;
    }

    @GetMapping( "/hotelList" )
    public ResponseEntity<List<HotelIdModel>> getAllHotels()
    {
        List<HotelIdModel> hotelsList = hotelService.getAllHotels();
        ResponseEntity<List<HotelIdModel>> responseEntity = new ResponseEntity<>( hotelsList, HttpStatus.OK );
        return responseEntity;
    }

    @GetMapping( "/hotels" )
    public ResponseEntity<List<HotelModel>> getHotels()
    {
        List<HotelModel> hotelsList = hotelService.getHotels();
        ResponseEntity<List<HotelModel>> responseEntity = new ResponseEntity<>( hotelsList, HttpStatus.OK );
        return responseEntity;
    }

    @PostMapping( "/search" )
    public ResponseEntity<List<HotelRoomTypeModel>> search( @RequestBody SearchModel searchModel )
    {
        List<HotelRoomTypeModel> hotelsList = hotelService.search(searchModel);
        //ResponseEntity<List<HotelRoomTypeModel>> responseEntity = new ResponseEntity<>( hotelsList, HttpStatus.OK );
        //return responseEntity;
        return null;
    }

//    @PutMapping("/hotels/{hotelId}")
//    public  ResponseEntity<HotelModel>  updateHotel( @RequestBody HotelModel hotelModel, @PathVariable  Long hotelId){
//        hotelModel = hotelService.updateHotel( hotelModel,hotelId );
//        ResponseEntity<HotelModel> responseEntity = new ResponseEntity<>( hotelModel,HttpStatus.OK);
//        return responseEntity;
//    }
//
//    @PatchMapping("/hotels/update-number/{hotelId}")
//    public  ResponseEntity<HotelModel>  updateNumber(@RequestBody HotelModel hotelModel,@PathVariable Long hotelId){
//        hotelModel = hotelService.updateNumber( hotelModel,hotelId );
//        ResponseEntity<HotelModel> responseEntity = new ResponseEntity<>( hotelModel,HttpStatus.OK);
//        return responseEntity;
//    }
//
//    @DeleteMapping("/hotels/{hotelId}")
//    public ResponseEntity deleteHotel(@PathVariable Long hotelId){
//        hotelService.deleteHotel(hotelId);
//        ResponseEntity<Void> responseEntity = new ResponseEntity<>( null,HttpStatus.NO_CONTENT);
//        return responseEntity;
//    }
}
