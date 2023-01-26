package org.roronoa.youbooking.service.Imp;


import org.roronoa.youbooking.entity.Role;
import org.roronoa.youbooking.repository.RoleRepository;
import org.roronoa.youbooking.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role getRole(Long id_role) {
        Optional<Role> role = roleRepository.findById(id_role);
        if (role.isPresent()){
            return role.get();
        }
        return null;
    }
}
