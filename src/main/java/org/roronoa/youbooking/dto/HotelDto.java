package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
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
    private Long id;
    private String name;
    private String description;

    private UserAppDto userApp;
    private AddressDto address;

    private List<AttachmentDto> attachments;

   private List<RoomDto> rooms;
    private boolean available;
    private String statusOffer;

    @Override
    public String toString() {
        return "HotelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userApp=" + userApp +
                ", address=" + address +
                ", attachments=" + attachments +
                ", rooms=" + rooms +
                ", available=" + available +
                ", statusOffer='" + statusOffer + '\'' +
                '}';
    }
}