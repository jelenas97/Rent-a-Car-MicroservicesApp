package com.authentication.service;


import com.authentication.model.Agent;

public interface AgentService {
    Agent save(Agent agent);
    Agent findById(long id);
}
