package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByMetierId(long MetierId);
    Optional<Type> findByTypeLib(String typeLib);
    Optional<Type> findByArticlesId(long articlesId);
}
