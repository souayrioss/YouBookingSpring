package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {
}