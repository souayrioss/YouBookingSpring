package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    Optional<UserApp> findByUuid(String uuid);

    UserApp findByEmail(String email);
}