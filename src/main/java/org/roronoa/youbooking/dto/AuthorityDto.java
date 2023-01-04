package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.roronoa.youbooking.entity.Authority;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Authority} entity
 */
@Data
public class AuthorityDto implements Serializable {
    @NotNull
    @NotEmpty
    private String reference;
    private List<RoleDto> roles;
}