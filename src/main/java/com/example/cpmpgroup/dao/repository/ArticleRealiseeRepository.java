package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.ArticleRealisee;
import com.example.cpmpgroup.dao.models.ArticleRealiseeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRealiseeRepository extends JpaRepository<ArticleRealisee, ArticleRealiseeId> {
    public List<ArticleRealisee>findByAttachementId(Long id );
}
