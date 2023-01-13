package org.roronoa.youbooking.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.entity.Address;
import org.roronoa.youbooking.repository.AddressRepository;
import org.roronoa.youbooking.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements IAddressService {
    private final AddressRepository addressRepository;
    @Override
    public Address addAddress(@Valid Address address) {
        return addressRepository.save(address);
    }
}
