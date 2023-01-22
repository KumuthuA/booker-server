package com.booker.booker.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table( name = "HOTEL" )
@Getter
@Setter
@NoArgsConstructor
public class HotelEntity
{


    @Id
    @GeneratedValue( generator = "UUID" )
    @GenericGenerator( name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator", parameters = {
            @Parameter( name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy" )
    } )
//    @GeneratedValue( generator = "uuid2" )
//    @GenericGenerator( name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
//    @GeneratedValue( strategy = GenerationType.SEQUENCE )
//    @Column( length = 8 )
    private String hotelId;
    @Column( nullable = false )
    private String hotelName;
    @Column( nullable = false )
    private String address;
    @Column( nullable = false )
    private String city;
    @Column( nullable = false )
    private String contactNo;
    @Column( nullable = false )
    private String email;

}
