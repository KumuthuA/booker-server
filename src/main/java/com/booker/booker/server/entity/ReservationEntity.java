package com.booker.booker.server.entity;


import com.booker.booker.server.helpers.compositeKeys.ReservationId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

@Entity
@Table( name = "RESERVATION" )
@Getter
@Setter
@Data
@NoArgsConstructor
@IdClass( ReservationId.class )
public class ReservationEntity
{
    @Id
    @GeneratedValue( generator = "UUID" )
    @GenericGenerator( name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator", parameters = {
            @Parameter( name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy" )
    } )
    private String reservationId;
    @Id
    @ManyToOne( fetch = FetchType.LAZY, optional = false )
    @JoinColumn( name = "room_type_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    private RoomTypeEntity roomTypeEntity;
    @Column( nullable = false, updatable = false, name = "checkin" )
    private LocalDateTime checkIn;
    @Column( nullable = false, updatable = false, name = "checkout" )
    private LocalDateTime checkOut;
    @Column( nullable = false, updatable = false, name = "room_count" )
    private Integer roomCount;
}
