package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq")
    @Column(nullable = false)
    private Long idReservation;

    @NotNull
    @NotEmpty
    @Column(unique = true, nullable = false,length = 60)
    private String uuid;

    private LocalDate dateReservation;
    private LocalDate dateDebut;
    @NotEmpty
    private LocalDate dateFin;
    @NotEmpty
    private int range;
    @NotEmpty
    private float totalPrice;


    @ManyToMany
    @JoinTable(name = "T_reservations_rooms__Associations",
            joinColumns = @JoinColumn( name = "idReservation" ),
            inverseJoinColumns = @JoinColumn( name = "idRoom" ) )
    private List<Room> rooms;

    @ManyToOne
    private UserApp userApp;




}