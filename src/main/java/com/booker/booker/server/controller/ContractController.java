package com.booker.booker.server.controller;

import com.booker.booker.server.model.ContractModel;
import com.booker.booker.server.model.HotelModel;
import com.booker.booker.server.service.ContractService;
import com.booker.booker.server.service.HotelService;
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
@RequestMapping("/api/v1")
public class ContractController
{   @Autowired
private ContractService contractService;

    @PostMapping("/contracts")
    public ResponseEntity<ContractModel> saveContract( @RequestBody ContractModel contractModel ){
        contractModel = contractService.saveContract( contractModel );
        ResponseEntity<ContractModel> responseEntity= new ResponseEntity<>(contractModel, HttpStatus.CREATED  ) ;
        return responseEntity;
    }

    @GetMapping("/contracts")
    public  ResponseEntity<List<ContractModel>>  getAllContracts(){
        List<ContractModel> contractsList = contractService.getAllContracts();
        ResponseEntity<List<ContractModel>> responseEntity = new ResponseEntity<>(  contractsList, HttpStatus.OK);
        return responseEntity;
    }
}
