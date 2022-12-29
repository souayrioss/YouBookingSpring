package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}