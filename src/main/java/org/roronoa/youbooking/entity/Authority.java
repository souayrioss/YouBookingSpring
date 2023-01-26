package org.roronoa.youbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Authority implements Serializable {
    @Id
    @SequenceGenerator(name = "authority_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "authority_seq")
    @Column(nullable = false,unique = true)
    private Long idAuthority;

    @NotNull
    @NotEmpty
    @Column(nullable = false,length = 20)
    private String reference;
    @NotNull
    @NotEmpty
    @Column(nullable = false,length = 100)
    private String description;

    @ManyToMany
    @JoinTable(name = "T_roles_authorities__Associations",
            joinColumns = @JoinColumn( name = "idAuthority" ),
            inverseJoinColumns = @JoinColumn( name = "idRole" ) )
    private List<Role> roles;

}
