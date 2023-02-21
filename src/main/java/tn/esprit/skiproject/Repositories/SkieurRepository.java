package tn.esprit.skiproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Skieur;
@Repository
public interface SkieurRepository extends CrudRepository<Skieur,Long> {
}
