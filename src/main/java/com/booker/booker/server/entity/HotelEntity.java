package com.booker.booker.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="HOTEL")
@Getter
@Setter
@NoArgsConstructor
public class HotelEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(length = 8)
    private Integer hotelId;
    @Column(nullable=false)
    private String hotelName;
    @Column(nullable=false)
    private String address;
    @Column(nullable=false)
    private String city;
    @Column(nullable=false)
    private String contactNo;
    @Column(nullable=false)
    private String email;

}
