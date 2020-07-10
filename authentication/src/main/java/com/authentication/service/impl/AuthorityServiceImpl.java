package com.authentication.service.impl;


import com.authentication.model.Authority;
import com.authentication.repository.AuthorityRepository;
import com.authentication.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority findById(Long id) {
        return this.authorityRepository.getOne(id);
    }

    @Override
    public Authority findByName(String name) {
        return this.authorityRepository.findByName(name);
    }
}
