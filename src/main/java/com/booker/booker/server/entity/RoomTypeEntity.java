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

@Entity
@Table( name = "ROOM_TYPE" )
@Getter
@Setter
@NoArgsConstructor
public class RoomTypeEntity
{
    //@GeneratedValue( strategy = GenerationType.SEQUENCE )
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
//    @GeneratedValue( generator = "uuid2" )
//    @GenericGenerator( name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
    private Integer roomTypeId;
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "contract_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    private ContractEntity contractEntity;
    @Column( nullable = false )
    private String typeName;
    @Column( nullable = false )
    private Integer roomCount;
    @Column( nullable = false )
    private Integer maxAdults;
    @Column( nullable = false )
    private Float price;
}
