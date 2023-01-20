package com.booker.booker.server.service;

import com.booker.booker.server.model.ContractModel;

import java.util.List;

public interface ContractService
{
    ContractModel saveContract( ContractModel contractModel);
    List<ContractModel> getAllContracts();
    List<ContractModel> getAllValidContracts();
}
