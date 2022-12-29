package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}