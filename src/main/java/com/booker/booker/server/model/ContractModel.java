package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ContractModel
{
    private Integer contractId;
    private Integer hotelId;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean isValid;
    private Float markup;
}
