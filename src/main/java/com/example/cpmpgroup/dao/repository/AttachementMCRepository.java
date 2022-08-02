package com.example.cpmpgroup.dao.repository;

import com.example.cpmpgroup.dao.models.AttachementMC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachementMCRepository extends JpaRepository<AttachementMC, Long> {
    public AttachementMC findBycodeAttachementMC(String code );
    public List<AttachementMC>findByOrdreTraveauxId(Long id );
}
