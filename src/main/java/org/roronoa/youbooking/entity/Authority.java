package org.roronoa.youbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Authority {
    @Id
    @SequenceGenerator(name = "authority_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "authority_seq")
    @Column(nullable = false,unique = true)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(nullable = false,length = 20)
    private String reference;

    @ManyToMany
    @JoinTable(name = "T_roles_authorities__Associations",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

}
