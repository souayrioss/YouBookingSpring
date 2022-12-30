package org.roronoa.youbooking.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private final Long id;
    private final String locality;
}