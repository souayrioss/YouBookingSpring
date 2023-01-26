package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @SequenceGenerator(name = "hotel_seq",allocationSize = 1,initialValue = 1)
    @Column(nullable = false)
    private Long id;

    @NotNull @NotEmpty
    @Column(unique = true, nullable = false,length = 60)
    private String uuid;
    @NotNull @NotEmpty
    @Column(nullable = false,length = 20)
    private String name;
    @NotNull
    @NotEmpty
    @Column(nullable = false,length = 150)
    private String description;
    @ManyToOne
    private UserApp userApp;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "hotel")
    private List<Attachment> attachments = new ArrayList<>();
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();
    private boolean available;
    @Enumerated(EnumType.STRING)
    private StatusOffer statusOffer=StatusOffer.PENDING;

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", statusOffer=" + statusOffer +
                '}';
    }
}