package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private final String name;
    private final List<CityDto> cities;
}