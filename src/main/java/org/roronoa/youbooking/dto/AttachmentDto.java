package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.roronoa.youbooking.entity.RoomType;

import java.io.Serializable;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Attachment} entity
 */
@Data
public class AttachmentDto implements Serializable {
    private Long id;
    private String uuid;
    @NotEmpty
    @NotNull
    private String fileName;
    private String attachmentType;


    @Override
    public String toString() {
        return "AttachmentDto{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", attachmentType='" + attachmentType + '\'' +
                '}';
    }
}