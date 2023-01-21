package com.booker.booker.server.helpers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeConverter
{
    public LocalDateTime utcToLocalDateTime( LocalDateTime dateTime )
    {
        ZoneId originalZoneId = ZoneId.of( "UTC" );
        ZoneId newZoneId = ZoneId.of( "Asia/Kolkata" );
        ZonedDateTime zonedDateTime = dateTime.atZone( originalZoneId );
        LocalDateTime convertedDateTime = zonedDateTime.withZoneSameInstant( newZoneId ).toLocalDateTime();
        return convertedDateTime;
    }
}
