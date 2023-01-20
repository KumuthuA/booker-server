package com.booker.booker.server.service;

import com.booker.booker.server.model.RoomTypeModel;

import java.util.List;

public interface RoomTypeService
{
    RoomTypeModel saveRoomType( RoomTypeModel hotelModel);
    List<RoomTypeModel> getAllRoomTypes();
}
