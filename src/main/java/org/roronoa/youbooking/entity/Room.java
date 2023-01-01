package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq")
    @Column(nullable = false)
    private Long idRoom;


    @NotEmpty
    @NotNull
    @Column(nullable = false,length = 20)
    private String reference;
    @NotEmpty
    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private boolean reserved;
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoomType roomType;

    @ManyToMany @Valid
    @JoinTable(name = "T_reservations_rooms__Associations",
            joinColumns = @JoinColumn( name = "idRoom" ),
            inverseJoinColumns = @JoinColumn( name = "idReservation" ) )
    private List<Reservation> reservations;

    @ManyToOne
    private Hotel hotel;




}