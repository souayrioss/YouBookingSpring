package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.City} entity
 */
@Data
public class CityDto implements Serializable {
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    private List<AddressDto> addresses;
}