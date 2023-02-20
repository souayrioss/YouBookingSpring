package org.roronoa.youbooking.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.entity.Attachment;
import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.repository.AttachmentRepository;
import org.roronoa.youbooking.service.IAttachmentService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImp implements IAttachmentService {

    private final AttachmentRepository attachmentRepository;
    @Override
    public Attachment addAttachment(@Valid Attachment attachment) {
        return attachmentRepository.save(attachment);
    }
}
