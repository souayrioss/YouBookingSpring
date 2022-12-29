package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}