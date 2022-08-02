package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.Attachement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttachementRepository extends JpaRepository<Attachement, Long> {

    public Attachement findByCodeAttachement(String code);
public Optional<Attachement> findById(Long id );

public List<Attachement> findByBonDeCommandeId(Long id );

/*List<Attachement> findByDateAttachementBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);*/

    @Query("SELECT a FROM Attachement a where a.dateAttachement between :date1 and  :date2")
    public List<Attachement> getbetweendate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


}

