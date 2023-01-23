package com.booker.booker.server.repository;

import com.booker.booker.server.entity.HotelEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class HotelRepositoryTest
{

    @Autowired
    private HotelRepository hotelRepositoryTest;

    @AfterEach
    void tearDown()
    {
        hotelRepositoryTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenHotelDoesNotExists()
    {
        //given
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setEmail( "abc@gmail.com" );
        hotelEntity.setHotelName( "abc" );
        hotelEntity.setCity( "Colombo" );
        hotelEntity.setContactNo( "0715675674" );
        hotelEntity.setAddress( "18, Main Road, Kiribathgoda" );
        HotelEntity he = hotelRepositoryTest.save( hotelEntity );
        //when
        Boolean exists = hotelRepositoryTest.existsByHotelId( "jhsgeufyasxaw" );

        //then
        assertThat( exists ).isFalse();
    }

    @Test
    void existsByHotelId()
    {
        //given
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setEmail( "abc@gmail.com" );
        hotelEntity.setHotelName( "abc" );
        hotelEntity.setCity( "Colombo" );
        hotelEntity.setContactNo( "0715675674" );
        hotelEntity.setAddress( "18, Main Road, Kiribathgoda" );
        HotelEntity he = hotelRepositoryTest.save( hotelEntity );
        //when
        Boolean exists = hotelRepositoryTest.existsByHotelId( he.getHotelId() );

        //then
        assertThat( exists ).isTrue();
    }

    @Test
    void findByHotelId()
    {
        //given
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setEmail( "abc@gmail.com" );
        hotelEntity.setHotelName( "abc" );
        hotelEntity.setCity( "Colombo" );
        hotelEntity.setContactNo( "0715675674" );
        hotelEntity.setAddress( "18, Main Road, Kiribathgoda" );
        HotelEntity he = hotelRepositoryTest.save( hotelEntity );
        //when
        Optional<HotelEntity> hotel = hotelRepositoryTest.findByHotelId( he.getHotelId() );

        //then
        assertThat( hotel ).isNotNull();
    }

    @Test
    void findByEmail()
    {
        //given
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setEmail( "abc@gmail.com" );
        hotelEntity.setHotelName( "abc" );
        hotelEntity.setCity( "Colombo" );
        hotelEntity.setContactNo( "0715675674" );
        hotelEntity.setAddress( "18, Main Road, Kiribathgoda" );
        hotelRepositoryTest.save( hotelEntity );

        //when
        Optional<HotelEntity> hotel = hotelRepositoryTest.findByEmail( "abc@gmail.com" );

        //then
        assertThat( hotel ).isNotNull();
    }
}