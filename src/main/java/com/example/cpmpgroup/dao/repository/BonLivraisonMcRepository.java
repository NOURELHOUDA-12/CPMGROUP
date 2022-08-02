package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.BonLivraisonMC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonMcRepository extends JpaRepository<BonLivraisonMC,Long > {
    List<BonLivraisonMC> findByOrdreDeTraveauxId(long otID);
    BonLivraisonMC findBycodeBonLivraisonMC(String code);
}
