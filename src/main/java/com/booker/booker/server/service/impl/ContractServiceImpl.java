package com.booker.booker.server.service.impl;

import com.booker.booker.server.converter.ContractConverter;
import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.model.ContractModel;
import com.booker.booker.server.repository.ContractRepository;
import com.booker.booker.server.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService
{
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractConverter contractConverter;
    @Override
    public ContractModel saveContract( ContractModel contractModel )
    {
        ContractEntity ce = contractConverter.convertModelToEntity( contractModel );
        ce = contractRepository.save(ce);
        contractModel = contractConverter.convertEntityToModel( ce );
        return contractModel;
    }

    @Override
    public List<ContractModel> getAllContracts()
    {
        List<ContractEntity> contractEntityList = (List<ContractEntity>)contractRepository.findAll();
        List<ContractModel> contractModelList = new ArrayList<>();
        for(ContractEntity ce:contractEntityList){
            ContractModel contractModel = contractConverter.convertEntityToModel( ce );
            contractModelList.add(contractModel);
        }
        return contractModelList;
    }

    @Override
    public List<ContractModel> getAllValidContracts()
    {
        List<ContractEntity> contractEntityList = (List<ContractEntity>)contractRepository.findAll();
        List<ContractModel> contractModelList = new ArrayList<>();
        for(ContractEntity ce:contractEntityList){
            ContractModel contractModel = contractConverter.convertEntityToModel( ce );
            contractModelList.add(contractModel);
        }
        return contractModelList;
    }
}
