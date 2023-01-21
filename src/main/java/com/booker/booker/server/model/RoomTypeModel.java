package com.booker.booker.server.model;

import com.booker.booker.server.entity.ContractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTypeModel
{
    private Integer roomTypeId;
    private ContractEntity contractEntity;
    private String typeName;
    private Integer roomCount;
    private Integer maxAdults;
    private Float price;
}
