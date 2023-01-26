package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    @SequenceGenerator(name = "city_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long id;

    @NotNull @NotEmpty @NotBlank
    private String name;
    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    @ManyToOne @Valid
    private Country country;

}