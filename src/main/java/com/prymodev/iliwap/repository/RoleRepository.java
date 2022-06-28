package com.prymodev.iliwap.repository;

import com.prymodev.iliwap.entity.AppRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<AppRole, String> {
    public AppRole findByRoleName(String role);
}
