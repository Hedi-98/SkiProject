package tn.esprit.skiproject.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.skiproject.Entities.Abonnement;
import tn.esprit.skiproject.Entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Long> {
    List<Abonnement> getSubscriptionByTypeAbonOrderByDateDebut(TypeAbonnement type);
    @Query("SELECT  a FROM Abonnement a where  a.dateDebut >=? 1 and a.dateFin <=? 2 ")
    List<Abonnement> retrieveSubscriptionsByDates(@PathVariable("dateDebut") LocalDate datedebut , @PathVariable("dateFin")LocalDate datefin);
}
