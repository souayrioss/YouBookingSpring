package org.roronoa.youbooking.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class RoleDto implements Serializable {
    private  Long id;
    @NotNull
    @NotEmpty
    private  String name;
    private List<AuthorityDto> authorities;

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}