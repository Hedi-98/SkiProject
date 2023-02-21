package tn.esprit.skiproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Piste;
@Repository
public interface PisteRepository extends CrudRepository<Piste,Long> {
}
