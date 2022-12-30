package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq")
    @Column(nullable = false)
    private Long id;
    @NotNull @NotEmpty
    @Column(nullable = false,length = 20)
    private String name;
    @ManyToOne
    private UserApp userApp;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "hotel")
    private List<Attachment> attachments = new ArrayList<>();
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();
    private boolean available;
    private StatusOffer statusOffer;
}