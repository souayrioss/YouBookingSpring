package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}