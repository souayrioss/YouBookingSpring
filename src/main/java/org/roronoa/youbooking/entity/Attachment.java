package org.roronoa.youbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotEmpty
    @Column(unique = true, nullable = false,length = 60)
    private String uuid;

/*    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "file" )
    private byte[] file;*/

    @NotEmpty @NotNull
    private String fileUrl;
    @ManyToOne
    private Hotel hotel;


}