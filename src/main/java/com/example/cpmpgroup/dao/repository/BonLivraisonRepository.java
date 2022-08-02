package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.BonLivraisonProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonRepository  extends JpaRepository<BonLivraisonProjet,Long > {
    List<BonLivraisonProjet> findByBonDeCommandeId(long bcID);
    BonLivraisonProjet findByCodeBonLivraisonProj( String code);

}
