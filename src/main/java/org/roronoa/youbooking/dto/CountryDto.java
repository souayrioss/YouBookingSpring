package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Country} entity
 */
@Data
public class CountryDto implements Serializable {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    private List<CityDto> cities;
}