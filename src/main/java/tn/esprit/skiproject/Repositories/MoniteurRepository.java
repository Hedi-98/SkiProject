package tn.esprit.skiproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Moniteur;

@Repository
public interface MoniteurRepository extends CrudRepository<Moniteur,Long> {
}
