package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long id;
    private String locality;


    @ManyToOne
    private City city;

}