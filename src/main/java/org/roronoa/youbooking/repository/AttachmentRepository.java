package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}