package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContractModel
{
    private Integer contractId;
    private Integer contractNo;
    private String hotelName;
    private String city;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean isValid;
    private Float markup;
}
