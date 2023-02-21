package tn.esprit.skiproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Inscription;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription,Long> {
}
