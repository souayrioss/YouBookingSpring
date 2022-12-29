package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq")
    @Column(nullable = false)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String name;
    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    @ManyToOne @Valid
    private Country country;

}