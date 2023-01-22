package com.booker.booker.server.controller;

import com.booker.booker.server.model.RoomTypeModel;
import com.booker.booker.server.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping( "/api/v1" )
public class RoomTypeController
{
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping( "/roomTypes/{contractId}" )
    public ResponseEntity<List<RoomTypeModel>> getRoomTypes( @PathVariable Integer contractId )
    {
        List<RoomTypeModel> roomTypeModelList = roomTypeService.getRoomTypes( contractId );
        ResponseEntity<List<RoomTypeModel>> responseEntity = new ResponseEntity<>( roomTypeModelList, HttpStatus.OK );
        return responseEntity;
    }
}

