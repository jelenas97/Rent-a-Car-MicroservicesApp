package com.authentication.service.impl;

import com.authentication.model.Agent;
import com.authentication.repository.AgentRepository;
import com.authentication.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    @Override
    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent findById(long id){ return agentRepository.findById(id);}
}
