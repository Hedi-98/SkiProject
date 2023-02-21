package tn.esprit.skiproject.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Cours;

@Repository
public interface CoursRepository extends CrudRepository<Cours,Long> {
}
