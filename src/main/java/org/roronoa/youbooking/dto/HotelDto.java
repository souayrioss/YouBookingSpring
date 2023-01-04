package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.entity.RoomType;
import org.roronoa.youbooking.entity.StatusOffer;
import org.roronoa.youbooking.entity.UserApp;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Hotel} entity
 */
@Data
public class HotelDto implements Serializable {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String description;
    private UserApp userApp;
    private AddressDto address;
    private List<AttachmentDto> attachments;
    private List<RoomDto> rooms;
    private boolean available;
    private String statusOffer;

}