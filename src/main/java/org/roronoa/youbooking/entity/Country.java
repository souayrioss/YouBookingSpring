package org.roronoa.youbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long id;
    @NotNull @NotEmpty @NotBlank
    @Column(nullable = false,unique = true)
    private String name;
    @OneToMany(mappedBy = "country")
    private List<City> cities;

}