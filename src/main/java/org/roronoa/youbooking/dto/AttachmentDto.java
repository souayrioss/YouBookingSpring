package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Attachment} entity
 */
@Data
public class AttachmentDto implements Serializable {

    private final String uuid;
    @NotEmpty
    @NotNull
    private final String fileUrl;
    private final HotelDto hotel;
}