package com.example.cpmpgroup.dao.repository;

import java.util.Optional;

import com.example.cpmpgroup.dao.models.ERole;
import com.example.cpmpgroup.dao.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);

    //Role findRoleByUsersId(Long userId );
    //Role findByUsersId(Long id);
}

