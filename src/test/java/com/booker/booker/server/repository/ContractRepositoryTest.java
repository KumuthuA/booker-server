package com.booker.booker.server.repository;

import com.booker.booker.server.entity.ContractEntity;
import com.booker.booker.server.entity.HotelEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ContractRepositoryTest
{

    @Autowired
    private HotelRepository hotelRepositoryTest;
    @Autowired
    private ContractRepository contractRepositoryTest;

    @AfterEach
    void tearDown()
    {
        contractRepositoryTest.deleteAll();
    }

//    @Test
//    void findDistinctByStartLessThanEqualAndEndGreaterThanEqual()
//    {
//        //given
//        HotelEntity hotelEntity = new HotelEntity();
//        hotelEntity.setEmail( "abc@gmail.com" );
//        hotelEntity.setHotelName( "abc" );
//        hotelEntity.setCity( "Colombo" );
//        hotelEntity.setContactNo( "0715675674" );
//        hotelEntity.setAddress( "18, Main Road, Kiribathgoda" );
//        HotelEntity he = hotelRepositoryTest.save( hotelEntity );
//        ContractEntity contractEntity1 = new ContractEntity();
//        contractEntity1.setContractId( 234 );
//        contractEntity1.setStart( LocalDateTime.now().minusDays( 20 ) );
//        contractEntity1.setEnd( LocalDateTime.now().plusDays( 10 ) );
//        contractEntity1.setMarkup( 0.75F );
//        contractEntity1.setHotelEntity( he );
//        ContractEntity contractEntity2 = new ContractEntity();
//        contractEntity2.setContractId( 698 );
//        contractEntity2.setStart( LocalDateTime.now().minusDays( 20 ) );
//        contractEntity2.setEnd( LocalDateTime.now().minusDays( 3 ) );
//        contractEntity2.setMarkup( 0.75F );
//        contractEntity2.setHotelEntity( he );
//        contractRepositoryTest.save( contractEntity1 );
//        contractRepositoryTest.save( contractEntity2 );
//
//        //when
//        List<com.booker.booker.server.repository.HotelEntity> hotelEntityList = contractRepositoryTest.findDistinctByStartLessThanEqualAndEndGreaterThanEqual( LocalDateTime.now().minusDays( 12 ), LocalDateTime.now() );
//
//        //then
//        assertThat( hotelEntityList.get( 0 ).getHotelEntity().getHotelId() ).isEqualTo( hotelEntity.getHotelId() );
//    }
//
//    @Test
//    void findByStartLessThanEqualAndEndGreaterThanEqual()
//    {
//    }
//
//    @Test
//    void findByEndGreaterThanEqual()
//    {
//        //given
//
//        //when
//        //then
//    }
}