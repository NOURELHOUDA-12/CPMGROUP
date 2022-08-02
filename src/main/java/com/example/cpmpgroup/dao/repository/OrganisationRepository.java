package com.example.cpmpgroup.dao.repository;

import com.example.cpmpgroup.dao.models.Organisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Optional<Organisation> findByCode(String Code);

    Optional<Organisation> findByBonDeCommandesId(long bonDeCommandeId);


   Optional<Organisation> findByUsersId(Long  userId );

   Optional<Organisation> findByUsersUsername(String userName );

    Optional<Organisation> findByNom(String nom );

    @Query(value = "SELECT e.nom, COUNT(e.nom) FROM BondeCommande  b join b.entreprise e where b.marchee.org.id =:orgId  GROUP BY e.nom")
    List<Object[]> countEntreprises(@Param("orgId") long orgId);

/*
@Query("SELECT  new com.example.managementbackend.dto.organisationUserJoin (o.nom ,u.username )FROM Organisation o JOIN o.users u")
    public List<organisationUserJoin> getInformations();


    @Query("SELECT  new com.example.managementbackend.dto.organisationUserJoin (o.nom ,u.username ,o.adresse)FROM Organisation o JOIN o.users u")
    public List<organisationUserJoin> getInformationsOrganisation();

 */
// trouver tous les organisation ainsi leurs users// pour le chart
    @Query (value = "SELECT  o.nom , COUNT(u.id) FROM Organisation o , User u where o.id=u.organisation.id GROUP BY o.nom" )
    public List<Object> getUsersByOrganisation();
// trouver le nombre  des marchees par organisation
@Query (value = "SELECT  o.nom , COUNT(m.id) FROM Organisation o , Marchee m where o.id=m.org.id GROUP BY o.nom" )
public List<Object> getMarcheeByOrganisation();
}




