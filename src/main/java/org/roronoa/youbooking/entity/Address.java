package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq")
    @Column(nullable = false)
    private Long id;
    private String locality;


    @ManyToOne @Valid
    private City city;

}