package com.booker.booker.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table( name = "CONTRACT" )
@Getter
@Setter
@NoArgsConstructor
public class ContractEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Integer contractId;
    @Column( nullable = false, unique = true )
    private Integer contractNo;
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "hotel_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    private HotelEntity hotelEntity;
    @Column( nullable = false )
    private LocalDateTime start;
    @Column( nullable = false )
    private LocalDateTime end;
    @Column( nullable = false )
    private Boolean isValid;
    @Column( nullable = false )
    private Float markup;
}

