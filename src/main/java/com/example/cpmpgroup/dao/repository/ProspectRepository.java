package com.example.cpmpgroup.dao.repository;

import com.example.cpmpgroup.dao.models.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectRepository extends JpaRepository<Prospect,Long> {
     public Prospect findByEmailAndCode(String email, String code);
public Prospect findByEmail(String email);

}
