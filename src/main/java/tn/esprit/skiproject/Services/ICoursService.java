package tn.esprit.skiproject.Services;

import tn.esprit.skiproject.Entities.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCourses();
    Cours addOrUpdateCours(Cours cours);
    void removeCours (Cours cours);
    Cours retrieveCours (Long numCours);
}
