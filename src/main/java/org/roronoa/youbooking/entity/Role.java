package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull @NotEmpty
    private String name;
    @OneToMany(mappedBy = "role")
    private List<UserApp> usersApp;
    @ManyToMany @Valid
    @JoinTable(name = "T_roles_authorities__Associations",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Authority> authorities ;
}