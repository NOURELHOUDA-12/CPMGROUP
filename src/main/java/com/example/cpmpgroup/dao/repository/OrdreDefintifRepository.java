package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.OrdreDefinitif;
import com.example.cpmpgroup.dao.models.OrdreDefinitifId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdreDefintifRepository extends JpaRepository<OrdreDefinitif, OrdreDefinitifId> {
    public List<OrdreDefinitif>findByordreDeTraveauxId( Long id);
}
