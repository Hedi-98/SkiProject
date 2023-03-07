package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.Cours;
import tn.esprit.skiproject.Entities.Moniteur;
import tn.esprit.skiproject.Repositories.CoursRepository;
import tn.esprit.skiproject.Repositories.MoniteurRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MoniteurService implements IMoniteurService {
    @Autowired
    MoniteurRepository moniteurRepo;
    @Autowired
    CoursRepository coursRepo;

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return (List<Moniteur>) moniteurRepo.findAll();
    }

    @Override
    public Moniteur addOrUpdateMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public void removeMoniteur(Moniteur moniteur) {
        moniteurRepo.delete(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepo.findById(numMoniteur).get();
    }

    @Transactional
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Set<Cours> cours = moniteur.getCours();
        if (cours == null) {
            cours = new HashSet<Cours>();
        }
        cours.add(coursRepo.findById(numCourse).get());
        moniteur.setCours(cours);
        //moniteur.getCours().add(coursRepo.findById(numCourse).get());
        return moniteurRepo.save(moniteur);
    }
}
