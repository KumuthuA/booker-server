package com.booker.booker.server.converter;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.model.ContractModel;
import org.springframework.stereotype.Component;

@Component
public class ContractConverter
{
    public ContractEntity convertModelToEntity( ContractModel contractModel){
        ContractEntity ce = new ContractEntity();
        //ce.setHotelId(contractModel.getHotelId());
        ce.setStart( contractModel.getStart() );
        ce.setEnd( contractModel.getEnd() );
        ce.setIsValid( contractModel.getIsValid() );
        ce.setMarkup( contractModel.getMarkup() );
        return ce;
    }

    public ContractModel convertEntityToModel( ContractEntity contractEntity){
        ContractModel cm = new ContractModel();
        cm.setContractId( contractEntity.getContractId() );
        //cm.setHotel(contractEntity.getHotel());
        cm.setStart( contractEntity.getStart() );
        cm.setEnd( contractEntity.getEnd() );
        cm.setIsValid( contractEntity.getIsValid() );
        cm.setMarkup( contractEntity.getMarkup() );
        return cm;
    }
}
