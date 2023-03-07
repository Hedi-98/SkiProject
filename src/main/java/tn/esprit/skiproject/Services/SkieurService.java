package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tn.esprit.skiproject.Entities.Abonnement;
import tn.esprit.skiproject.Entities.Piste;
import tn.esprit.skiproject.Entities.Skieur;
import tn.esprit.skiproject.Repositories.AbonnementRepository;
import tn.esprit.skiproject.Repositories.PisteRepository;
import tn.esprit.skiproject.Repositories.SkieurRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public class SkieurService implements ISkieurService {
    @Autowired
    SkieurRepository skieurRepo;
    @Autowired
    PisteRepository pisteRepo;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return (List<Skieur>) skieurRepo.findAll();
    }

    @Override
    public Skieur addOrUpdateSkieur(Skieur skieur) {
        //abonnementRepo.save(skieur.getAbonnement());
        //Abonnement ab= abonnementRepo.findById(skieur.getAbonnement().getNumAbon()).get();
        //skieur.setAbonnement(ab);
        return skieurRepo.save(skieur);
    }

    @Override
    public void removeSkieur(Skieur skieur) {
        skieurRepo.delete(skieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepo.findById(numSkieur).get();
    }

    @Transactional
    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur=skieurRepo.findById(numSkieur).get();
        Piste piste=pisteRepo.findById(numPiste).get();
        piste.getSkieurs().add(skieur);
        return skieurRepo.save(skieur);
    }

    @Override
    public Skieur addSkieurAndAssignToCourse(Skieur skieur) {
        return null;
    }
}
