package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.entity.Authority;
import org.roronoa.youbooking.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Authority} entity
 */
@Data
public class AuthorityDto implements Serializable {
    @NotNull
    @NotEmpty
    private final String reference;
    private final List<RoleDto> roles;
}