package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final Long id;
    @NotNull
    @NotEmpty
    private final String name;
    private final List<AuthorityDto> authorities;
}