package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class    Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long idRole;
    @NotNull @NotEmpty
    private String name;

    @ManyToMany @Valid
    @JoinTable(name = "T_roles_authorities__Associations",
            joinColumns = @JoinColumn( name = "idRole" ),
            inverseJoinColumns = @JoinColumn( name = "idAuthority" ) )
    private List<Authority> authorities ;
}