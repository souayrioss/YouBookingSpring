package org.roronoa.youbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachment_seq")
    @SequenceGenerator(name = "attachment_seq",allocationSize = 1,initialValue = 1)
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
    private String fileName;
    @ManyToOne
    private Hotel hotel;

    @Enumerated(EnumType.STRING)
    private RoomType attachmentType;


}