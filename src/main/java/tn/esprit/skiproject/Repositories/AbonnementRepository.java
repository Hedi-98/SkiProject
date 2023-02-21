package tn.esprit.skiproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Abonnement;
@Repository
public interface AbonnementRepository extends CrudRepository<Abonnement,Long> {
}
