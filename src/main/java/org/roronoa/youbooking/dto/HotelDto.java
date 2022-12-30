package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.entity.RoomType;
import org.roronoa.youbooking.entity.StatusOffer;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Hotel} entity
 */
@Data
public class HotelDto implements Serializable {
    @NotNull
    @NotEmpty
    private final String name;
    private final UserAppDto userApp;
    private final AddressDto address;
    private final List<AttachmentDto> attachments;
    private final List<RoomDto> rooms;
    private final boolean available;

    private StatusOffer statusOffer;

}