package com.booker.booker.server.service;

import com.booker.booker.server.model.ContractModel;
import com.booker.booker.server.model.ContractRoomTypeModel;

import java.util.List;

public interface ContractService
{
    ContractRoomTypeModel saveContract( ContractRoomTypeModel contractRoomTypeModel );

    List<ContractModel> getContracts();

//    List<ContractModel> getAllValidContracts();
}
