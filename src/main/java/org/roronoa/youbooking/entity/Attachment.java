package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachment_seq")
    @SequenceGenerator(name = "attachment_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Hotel hotel;


}