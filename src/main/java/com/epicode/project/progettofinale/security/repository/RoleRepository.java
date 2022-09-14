package com.epicode.project.progettofinale.security.repository;

import java.util.Optional;

import com.epicode.project.progettofinale.security.model.Role;
import com.epicode.project.progettofinale.security.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(Roles role);
}