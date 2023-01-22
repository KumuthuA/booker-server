package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTypeModel
{
    private String roomTypeId;
    private Integer contractEntityId;
    private String typeName;
    private Integer roomCount;
    private Integer maxAdults;
    private Float price;
}
