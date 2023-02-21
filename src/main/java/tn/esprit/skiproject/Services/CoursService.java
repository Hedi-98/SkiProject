package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.Cours;
import tn.esprit.skiproject.Repositories.CoursRepository;

import java.util.List;
@Service

public class CoursService implements ICoursService{
    @Autowired
    CoursRepository coursRepo;
    @Override
    public List<Cours> retrieveAllCourses() {
        return (List<Cours>) coursRepo.findAll();
    }
    @Override
    public Cours addOrUpdateCours(Cours cours) {
        return coursRepo.save(cours);
    }
    @Override
    public void removeCours(Cours cours) {
        coursRepo.delete(cours);
    }
    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepo.findById(numCours).get();
    }
}
