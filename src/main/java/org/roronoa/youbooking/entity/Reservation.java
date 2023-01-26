package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long idReservation;

    @NotNull
    @NotEmpty
    @Column(unique = true, nullable = false,length = 60)
    private String uuid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateReservation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    private int range;

    private Double totalPrice;


    @ManyToMany
    @JoinTable(name = "T_reservations_rooms__Associations",
            joinColumns = @JoinColumn( name = "idReservation" ),
            inverseJoinColumns = @JoinColumn( name = "idRoom" ) )
    private List<Room> rooms;

    @ManyToOne
    private UserApp userApp;

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", uuid='" + uuid + '\'' +
                ", dateReservation=" + dateReservation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", range=" + range +
                ", totalPrice=" + totalPrice +
                '}';
    }
}