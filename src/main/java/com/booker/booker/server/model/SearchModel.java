package com.booker.booker.server.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SearchModel
{
    private LocalDateTime start;
    private Integer nights;
    private List<String> roomDetails;
}
