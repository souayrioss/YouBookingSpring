package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}