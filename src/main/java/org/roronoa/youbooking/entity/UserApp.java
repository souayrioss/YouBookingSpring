package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq",allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    @NotNull @NotEmpty
    @Column(unique = true, nullable = false,length = 60)
    private String uuid;

    @NotNull @NotEmpty
    @Column(nullable = false,length = 30)
    private String fullName;
    @NotNull @NotEmpty @Email
    @Column(nullable = false,length = 60)
    private String email;
    @NotNull @NotEmpty
    @Column(nullable = false,length = 30)
    private String password;

    @NotNull @NotEmpty
    @Column(nullable = false,length = 20)
    private String phone;
    @ManyToOne @Valid
    private Role role;

    @OneToMany(mappedBy = "userApp")
    private List<Hotel> hotels = new ArrayList<>();

    @OneToMany(mappedBy = "userApp")
    private List<Reservation> reservations = new ArrayList<>();

}