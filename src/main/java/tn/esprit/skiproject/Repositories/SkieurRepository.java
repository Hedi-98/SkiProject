package tn.esprit.skiproject.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Skieur;
import tn.esprit.skiproject.Entities.TypeAbonnement;

import java.util.List;

@Repository
public interface SkieurRepository extends CrudRepository<Skieur, Long> {
    //@Query("select s from Skieur S join Abonnement A where A.typeAbon = :type ")
    List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement type);
}
