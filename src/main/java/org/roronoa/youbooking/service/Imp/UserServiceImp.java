package org.roronoa.youbooking.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.entity.Role;
import org.roronoa.youbooking.repository.UserAppRepository;
import org.roronoa.youbooking.service.IUserService;
import org.roronoa.youbooking.entity.UserApp;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImp implements IUserService {

    private final UserAppRepository userRepository;
    private final RoleServiceImp roleService;
    @Override
    public UserApp save(@Valid UserApp user) {
        user.setUuid(UUID.randomUUID().toString());
        Role role = roleService.getRole(3L);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public UserApp getUser(String uuid) {
        Optional<UserApp> user = userRepository.findByUuid(uuid);
        return user.orElse(null);
    }

    @Override
    public List<UserApp> getListUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails findByEmail(String email){
        UserApp userApp = userRepository.findByEmail(email);
        if (Objects.isNull(userApp)) {
            return null;
        }
        return new User(userApp.getUuid() ,userApp.getPassword(), Collections.singleton(new SimpleGrantedAuthority(userApp.getRole().getAuthorities().toString())));
    }
}