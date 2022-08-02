package com.example.cpmpgroup.dao.repository;


import com.example.cpmpgroup.dao.models.ArticleUtilisee;
import com.example.cpmpgroup.dao.models.AticleUtiliseeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleUtiliseeRepository extends JpaRepository<ArticleUtilisee, AticleUtiliseeId> {
    List<ArticleUtilisee> findAllByBondecommandeId(long bondecommandeId);
    Optional<ArticleUtilisee> findByBondecommandeIdAndArticleId(long bondecommandeId, long articleId);
    List<ArticleUtilisee> findAllByArticleId(long articleId);
   ArticleUtilisee findByBondecommandeId(Long id);


}
