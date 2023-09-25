package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.*;
import tn.esprit.skiproject.Repositories.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SkieurService implements ISkieurService {
    @Autowired
    SkieurRepository skieurRepo;
    @Autowired
    PisteRepository pisteRepo;
    @Autowired
    CoursRepository coursRepo;
    @Autowired
    InscriptionRepository inscriptionRepo;

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
        Skieur skieur = skieurRepo.findById(numSkieur).get();
        Piste piste = pisteRepo.findById(numPiste).get();
        piste.getSkieurs().add(skieur);
        return skieurRepo.save(skieur);
    }

    @Override
    public Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCours) {
        Skieur skieur1 = skieurRepo.save(skieur);
        Cours cours = coursRepo.findById(numCours).get();
        Set<Inscription> inscriptions = skieur1.getInscriptions();
        if (inscriptions == null) {
            inscriptions = new HashSet<Inscription>();
        }
        Inscription inscription = new Inscription();
        inscription.setSkieur(skieur1);
        inscription.setCours(cours);
        inscriptionRepo.save(inscription);
        skieur1.getInscriptions().add(inscription);
        return skieurRepo.save(skieur1);
    }
    /*public Skieur addSkieurAndAssignToCourse(Skieur skieur) {
        Set<Inscription> inscriptions=skieur.getInscriptions();
        for (Inscription inscription:inscriptions ) {
            Cours cours=inscription.getCours();
            cours.getInscriptions().add(inscription);
            coursRepo.save(cours);
        }
        return skieurRepo.save(skieur);
    }*/

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        /*Set<Skieur> skieurs = (Set<Skieur>) skieurRepo.findAll();
        List<Skieur> result = new ArrayList<Skieur>();
        for (Skieur skieur : skieurs) {
            if (skieur.getAbonnement().getTypeAbon() == typeAbonnement)
                result.add(skieur);
        }
        return result;*/
        return skieurRepo.findByAbonnement_TypeAbon(typeAbonnement);
    }
}
