package org.roronoa.youbooking.service;

import org.roronoa.youbooking.entity.Authority;

import java.util.List;

public interface IAuthorityService {
    List<Authority> getAuthoritiesByRole(Long idRole);
}
