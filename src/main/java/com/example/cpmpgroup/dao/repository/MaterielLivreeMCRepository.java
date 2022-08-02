package com.example.cpmpgroup.dao.repository;



import com.example.cpmpgroup.dao.models.MaterielLivreeMCId;
import com.example.cpmpgroup.dao.models.MaterielleLivreeMC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielLivreeMCRepository extends JpaRepository<MaterielleLivreeMC, MaterielLivreeMCId> {
}
