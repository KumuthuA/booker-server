package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ContractRoomTypeModel
{
    private Integer contractId;
    private Integer contractNo;
    private Integer hotelId;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean isValid;
    private Float markup;
    private List<RoomTypeModel> roomTypes;
}
