package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.City} entity
 */
@Data
public class CityDto implements Serializable {
    private final Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private final String name;
    private final List<AddressDto> addresses;
}