package org.roronoa.youbooking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private Long id;
    private String locality;
}