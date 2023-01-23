package com.booker.booker.server.controller;

import com.booker.booker.server.exception.ContractAlreadyExistsException;
import com.booker.booker.server.model.ContractModel;
import com.booker.booker.server.model.ContractRoomTypeModel;
import com.booker.booker.server.service.ContractService;
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
public class ContractController
{
    Logger logger = LoggerFactory.getLogger( ContractController.class );
    @Autowired
    private ContractService contractService;

    /*   POST method to save a contract
    @param ContractRoomTypeModel with contractID
    throw ContractAlreadyExistsException if the contractID already exists*/
    @PostMapping( "/contracts" )
    public ResponseEntity<ContractRoomTypeModel> saveContract( @RequestBody ContractRoomTypeModel contractRoomTypeModel ) throws ContractAlreadyExistsException
    {
        logger.info( "Saving the contract with the id :" + contractRoomTypeModel.getContractId() );
        contractRoomTypeModel = contractService.saveContract( contractRoomTypeModel );
        ResponseEntity<ContractRoomTypeModel> responseEntity = new ResponseEntity<>( contractRoomTypeModel, HttpStatus.CREATED );
        return responseEntity;
    }

    /*
        GET method to retrieve all the non-expired contracts
    */
    @GetMapping( "/contracts" )
    public ResponseEntity<List<ContractModel>> getContracts()
    {
        logger.info( "Requesting all the valid contracts" );
        List<ContractModel> contractsList = contractService.getContracts();
        ResponseEntity<List<ContractModel>> responseEntity = new ResponseEntity<>( contractsList, HttpStatus.OK );
        return responseEntity;
    }
}
