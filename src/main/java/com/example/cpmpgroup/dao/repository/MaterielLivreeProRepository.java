package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.MaterielLivreeId;
import com.example.cpmpgroup.dao.models.MaterielLivreePro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielLivreeProRepository  extends JpaRepository<MaterielLivreePro, MaterielLivreeId> {
}
