package com.authentication.service;

import com.authentication.model.Authority;

import java.util.List;

public interface AuthorityService {
    Authority findById(Long id);
    Authority findByName(String name);
}
