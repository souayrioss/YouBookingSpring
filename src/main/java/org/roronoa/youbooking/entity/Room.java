package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long idRoom;


    @NotEmpty
    @NotNull
    @Column(nullable = false,length = 20)
    private String reference;


    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private boolean reserved;
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoomType roomType;

    @ManyToMany
    @JoinTable(name = "T_reservations_rooms__Associations",
            joinColumns = @JoinColumn( name = "idRoom" ),
            inverseJoinColumns = @JoinColumn( name = "idReservation" ) )
    private List<Reservation> reservations;

    @ManyToOne
    private Hotel hotel;

    @Override
    public String toString() {
        return "Room{" +
                "idRoom=" + idRoom +
                ", reference='" + reference + '\'' +
                ", price=" + price +
                ", reserved=" + reserved +
                ", roomType=" + roomType +
                '}';
    }
}